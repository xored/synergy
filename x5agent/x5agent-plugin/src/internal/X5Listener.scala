package com.xored.x5agent.core.internal

import com.xored.sherlock.core._
import com.xored.sherlock.core.info._
import com.xored.emfjson._
import java.util.Date
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
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
      val emf2json = new Emf2Json

      val eclipseStatus = emf2json.serialize(SherlockCore.convert(status))
      val systemInfo = emf2json.serialize(Info.getSystem())
      val javaInfo = emf2json.serialize(Info.getJava())
      val eclipseInfo = emf2json.serialize(Info.getEclipse())

      val report = new JsonObject
      report.add("eclipseStatus", eclipseStatus)
      report.add("systemInfo", systemInfo)
      report.add("javaInfo", javaInfo)
      report.add("eclipseInfo", eclipseInfo)
      report.add("pluginId", new JsonPrimitive(pluginId))

      val jsonReport = report.toString
      val reportObj = Report(createdAt = new Date(), content = jsonReport)
      x5storage.save(reportObj)
      x5dispatcher.notifyGotSomethingToSubmit
    }

  }

}
