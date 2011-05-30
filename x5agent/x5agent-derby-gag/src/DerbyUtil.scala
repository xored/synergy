package com.xored.x5agent.core

object DerbyUtil {

  val errorStream = new java.io.OutputStream() {
    override def write(b:Int):Unit = { }     
  }

}
