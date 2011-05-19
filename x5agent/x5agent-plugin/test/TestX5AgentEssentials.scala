package com.xored.x5agent.core.internal

import java.util.UUID
import java.io.File

object TestX5AgentEssentials {
  val uuid = UUID.randomUUID()
  val userHome = System.getProperty("java.io.tmpdir")+"home"+uuid+"/"

  new File(userHome).mkdirs()
} 

trait TestX5AgentEssentials extends X5AgentEssentials {

  override protected def logDebug(msg:String) = println(msg)
  override protected def logInfo(msg:String) = println(msg)
  override protected def logError(msg:String) = println(msg)
  override protected def logError(msg:String, t:Throwable) = println(msg+" "+t)

  override protected def x5dirName:String = System.getProperty("java.io.tmpdir")
  override protected def userName:String = "x5user-"+TestX5AgentEssentials.uuid
  override protected def userHome:String = TestX5AgentEssentials.userHome 

}
