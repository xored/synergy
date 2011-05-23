package com.xored.x5agent.core.internal

import com.xored.sherlock.core._
import com.xored.sherlock.core.info._
import com.xored.emfjson._
import java.util.Date
import com.google.gson.Gson
import collection.JavaConversions

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
      val eclipseStatus = Emf2Json.serialize(SherlockCore.convert(status))
      val _system = Info.getSystem()
      val systemInfo = Emf2Json.serialize(_system)
      val javaInfo = Emf2Json.serialize(Info.getJava())
      val eclipseInfo = Emf2Json.serialize(Info.getEclipse())
      val report = Map(
        "eclipseStatus"->eclipseStatus
        ,"systemInfo"->systemInfo
        ,"javaInfo"->javaInfo
        ,"eclipseInfo"->eclipseInfo
        ,"pluginId"->pluginId
      )
      val jsonReport = gson toJson ( JavaConversions.asJavaMap( report ) )
      val reportObj = Report(createdAt = new Date(), content = jsonReport)
      x5storage.save(reportObj)
      x5dispatcher.notifyGotSomethingToSubmit
    }

  }

}
