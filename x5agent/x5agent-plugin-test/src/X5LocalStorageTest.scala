package com.xored.x5agent.core.internal

import java.io.File
import java.util.Date
import org.junit.Test

class X5LocalStorageTest { 

  object StorageComponent 
    extends X5LocalStorageComponentImpl 
    with TestX5AgentEssentials{}

  import org.junit.Assert._

  @Test  
  def wholeScenarion = {
    StorageComponent.x5storage.start
    assertTrue( new File(StorageComponent.x5storage.x5dbFileName).exists )
    assertEquals( Some("0.0.1"), StorageComponent.x5storage.databaseVersion )
    StorageComponent.x5storage.save(Report(content="test content", createdAt=new Date()))
    assertEquals(1, StorageComponent.x5storage.unsent(100).size) // the report we have saved!

    val reports = StorageComponent.x5storage.unsent(100)
    val ids = reports.map(_.id.get)
    for (id<-ids)
      StorageComponent.x5storage.markAsSent(id, new java.util.Date, "some remote id")
    assertEquals(0, StorageComponent.x5storage.unsent(100).size) // no unsent reports anymore
    StorageComponent.x5storage.save(Report(content="yet another test content", createdAt=new Date()))
    StorageComponent.x5storage.stop
    StorageComponent.x5storage.start
    assertEquals(1, StorageComponent.x5storage.unsent(100).size)
    assertEquals("yet another test content", StorageComponent.x5storage.unsent(100).head.content)
    for (i<- 0 until 100)
      StorageComponent.x5storage.save(Report(content="test content "+i, createdAt=new Date()))

    assertEquals( 42, StorageComponent.x5storage.unsent(42).size )

    StorageComponent.x5storage.stop
  }

}

