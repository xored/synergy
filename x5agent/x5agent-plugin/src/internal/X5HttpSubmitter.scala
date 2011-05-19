package com.xored.x5agent.core.internal

import scala.actors.{Actor, OutputChannel}
import org.eclipse.core.runtime.{IStatus, IProgressMonitor, Status}
import org.eclipse.core.runtime.jobs.{IJobChangeEvent, Job, JobChangeAdapter}
import com.google.gson.Gson

//
object Submit
object Submitted

// component
trait X5HttpSubmitterComponent {

  def x5submitter:X5HttpSubmitter

  trait X5HttpSubmitter extends Actor {
  }

}

// implementation
trait X5HttpSubmitterComponentImpl extends X5HttpSubmitterComponent {
  this: X5HttpSubmitterComponentImpl
        with X5LocalStorageComponent 
        with X5ConfigurationComponent 
        with X5AgentEssentials => 

  def x5submitter = X5HttpSubmitterImpl

  object X5HttpSubmitterImpl 
    extends X5HttpSubmitter 
    with HttpHelpers {
    start

    private val BULK_SIZE = 5 // no more than a 5 reports a time

    override def act =
      loop {
        react {
          case Submit => submit(sender)
        }
      }

    def submit(sender:OutputChannel[Any]):Unit = 
      try { 
        x5config.url match {
          case Some(url) => {
            val reports = x5storage.unsent(BULK_SIZE)
            if (reports.size > 0) {
              runSubmitJob(sender, url, reports)
            } else sender ! Submitted
          }
          case None => sender ! Submitted
        }
      } catch {
        case t => { sender ! Submitted; logError("Exception thrown when scheduling eclipse job", t) }
      }

    def runSubmitJob(sender:OutputChannel[Any], url:String, reports:List[Report]) = {
      val job = new Job("X5 agent reporting job") {
        override protected def run(monitor:IProgressMonitor):IStatus = {
          submitReports(url, reports)
          Status.OK_STATUS
        } 
      }

      job.addJobChangeListener(new JobChangeAdapter() {
        override def done(event:IJobChangeEvent):Unit = { sender ! Submitted }
      })

      job.setPriority(Job.SHORT)
      job.schedule()
    }

    import scala.collection.JavaConversions._
    def submitReports(url:String, reports:List[Report]) = {
      val bodies = reports.map(_.content)
      val jsonPayload = bodies.mkString("[",",","]")
      postJson(url, jsonPayload) fold (
        error => { logError("Can't submit reports", error.cause) }
        , {
          case (200|201, body) => {
            val gson = new Gson
            val reply = gson.fromJson(body, classOf[X5ServerReply])
            val sentDate = new java.util.Date
            reports.zip(scala.collection.JavaConversions.asScalaIterator[String](reply.ids.iterator).toList).map (t => {
              x5storage.markAsSent(t._1.id.get, sentDate, t._2)
            })
          }
          case (x, _) => logError("Can't submit reports. X5 Server returned response code "+x)
        }
      )
    }

    private class X5ServerReply {
      var ok:java.lang.Boolean = _
      var ids:java.util.List[String] = _
    }

  }

}
