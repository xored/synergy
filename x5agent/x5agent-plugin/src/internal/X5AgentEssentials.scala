package com.xored.x5agent.core.internal

import java.io.File
import java.net.URL
import org.apache.log4j._

import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.Plugin
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IWorkspace

case class X5AgentRuntimeException(msg:String,t:Throwable = null) 
  extends RuntimeException(msg,t)

trait X5AgentEssentials {
  protected def onStart:Unit

  protected def logDebug(msg:String):Unit
  protected def logInfo(msg:String):Unit
  protected def logError(msg:String):Unit
  protected def logError(msg:String, t:Throwable):Unit

  protected def x5dirName:String
  protected def userName:String
  protected def userHome:String

  protected def wrapExceptions[A]( fn: =>A ):Unit = 
    try { fn } catch {
      case t => logError("Exception thrown", t)
    }

  protected def fail(message:String, throwable:Throwable = null) =
    throw new X5AgentRuntimeException(message, throwable)

}

trait EclipseX5AgentEssentials extends X5AgentEssentials {
  this: EclipseX5AgentEssentials with Plugin =>

  override protected def x5dirName = getStateLocation().toFile.getPath.toString
  private val _userName:String = {
    val r = java.lang.System.getProperty("user.name")
    if (r == null) "unknown_user"
    else r.toLowerCase.replace("\\s+","_")
  }
  override protected def userName = _userName
  override protected def userHome = java.lang.System.getProperty("user.home")

  override protected def onStart = {
    val x5logFileName = x5dirName + "/" + userName + ".log"
    val logLayout = new PatternLayout("%d{ISO8601} %-5p %C[%t]: %m%n")
    val rootLogger = Logger.getRootLogger()
    rootLogger.setLevel( Level.INFO )
    val appender = new RollingFileAppender(logLayout, x5logFileName, true)
    appender.setMaxBackupIndex( 10 ) 
    appender.setMaxFileSize( "10MB" ) 
    rootLogger.addAppender(appender) 
  }

  private val log = Logger.getLogger(this.getClass())

  private def logWrap[A](msg:String, fn: =>A):Unit =
    try { fn } catch { 
      case x => {
        println("Can't write a message to log: "+msg+". Reason:")
        x.printStackTrace
      }
    }

  override protected def logDebug(msg:String) = logWrap(msg, ()=>{ log.debug(msg) })
  override protected def logInfo(msg:String) = logWrap(msg, ()=>{ log.info(msg) })
  override protected def logError(msg:String) = logWrap(msg, ()=>{ log.error(msg) })
  override protected def logError(msg:String, t:Throwable) = logWrap(msg, ()=>{ log.error(msg,t) })

}
