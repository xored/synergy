package com.xored.x5agent.core.internal

import org.specs2._
import java.io.File
import java.util.Date

class X5LocalStorageTest extends SpecificationWithJUnit { def is =

  "This is a specification to check the X5 local storage"                     ^
                                                                                p^
  "X5 agent local storage should"                                             ^
    "start and create database file"                                          ! startCreate ^
    "report database version as 0.0.1"                                        ! databaseVersion ^
    "save a report"                                                           ! save ^
    "get unsent reports"                                                      ! unsent ^
    "mark reports as sent"                                                    ! markAsSent ^
    "save a report that will survive shutdown"                                ! saveBeforeShutdown ^
    "shutdown gracefully"                                                     ! shutdown ^
    "start again and still contain the saved reports"                         ! secondStart ^
    "keep the contents of saved reports"                                      ! secondReportContent ^
    "be able to store many unsent reports at once"                            ! manyReports ^
    "return only requested number of unsent reports"                          ! limit ^
    "shutdown again"                                                          ! shutdownAgain ^
                                                                              end

  object StorageComponent 
    extends X5LocalStorageComponentImpl 
    with TestX5AgentEssentials{}
  
  def startCreate = {
    StorageComponent.x5storage.start
    (new File(StorageComponent.x5storage.x5dbFileName).exists) must beTrue
  }

  def databaseVersion = StorageComponent.x5storage.databaseVersion must beSome("0.0.1")

  def save = {
    StorageComponent.x5storage.save(Report(content="test content", createdAt=new Date()))
    true must beTrue // we only need to pass this step w/o any exceptions
  }

  def unsent = 
    StorageComponent.x5storage.unsent(100) must haveSize(1) // the report we have saved!

  def markAsSent = {
    val reports = StorageComponent.x5storage.unsent(100)
    val ids = reports.map(_.id.get)
    for (id<-ids)
      StorageComponent.x5storage.markAsSent(id, new java.util.Date, "some remote id")
    StorageComponent.x5storage.unsent(100) must haveSize(0) // no unsent reports anymore
  }

  def saveBeforeShutdown = {
    StorageComponent.x5storage.save(Report(content="yet another test content", createdAt=new Date()))
    true must beTrue // we only need to pass this step w/o any exceptions
  }

  def shutdown = {
    StorageComponent.x5storage.stop
    true must beTrue // we only need to pass this step w/o any exceptions
  }

  def secondStart = {
    StorageComponent.x5storage.start
    StorageComponent.x5storage.unsent(100) must haveSize(1)
  }

  def secondReportContent =
    StorageComponent.x5storage.unsent(100).head.content must beEqualTo("yet another test content")

  def manyReports = {
    for (i<- 0 until 100)
      StorageComponent.x5storage.save(Report(content="test content "+i, createdAt=new Date()))
    true must beTrue // we only need to pass this step w/o any exceptions    
  }

  def limit = 
    StorageComponent.x5storage.unsent(42) must haveSize(42)

  def shutdownAgain = {
    StorageComponent.x5storage.stop
    true must beTrue // we only need to pass this step w/o any exceptions
  }

}

