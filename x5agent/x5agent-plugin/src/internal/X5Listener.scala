package com.xored.x5agent.core.internal

import com.xored.sherlock.core._
import com.xored.sherlock.core.info._
import com.xored.emfjson._
import java.util.Date
import com.google.gson.Gson

import org.eclipse.core.runtime._

trait X5ListenerComponent {
  this: 
    X5ListenerComponent 
    with X5LocalStorageComponent 
    with X5HttpDispatcherComponent =>

  def x5listener:ILogListener

}

trait X5ListenerComponentImpl extends X5ListenerComponent {
  this: 
    X5ListenerComponent 
    with X5LocalStorageComponent
    with X5HttpDispatcherComponent
    with X5AgentEssentials =>

  def x5listener = X5ListenerImpl

  object X5ListenerImpl extends ILogListener {

    override def logging(status:IStatus, pluginId:String): Unit = wrapExceptions {
      val gson = new Gson
      val report = Map(
        "eclipseStatus"->Emf2Json.serialize(SherlockCore.convert(status))
        ,"systemInfo"->Emf2Json.serialize(Info.getSystem())
        ,"javaInfo"->Emf2Json.serialize(Info.getJava())
        ,"eclipseInfo"->Emf2Json.serialize(Info.getEclipse())
      )
      val jsonReport = gson toJson (report)
      val reportObj = Report(createdAt = new Date(), content = jsonReport)
      x5storage.save(reportObj)
      x5dispatcher.notifyGotSomethingToSubmit
    }

  }

}
