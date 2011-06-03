package com.xored.x5agent.core.internal

import org.eclipse.core.runtime.Platform
import java.sql._
import java.net.URLEncoder
import java.util.Date
import scala.io.Source

trait X5LocalStorageComponent {

  def x5storage:X5LocalStorage

  trait X5LocalStorage {
    def start:Unit
    def stop:Unit

    /** returns database version **/
    def databaseVersion:Option[String]
    /** saves a report **/
    def save(r:Report):Unit
    /** returns maxNumber of unsent reports **/
    def unsent(maxNumber:Int):List[Report]
    /** marks reports as sent **/
    def markAsSent(id:Int, at:Date, remoteId:String):Unit
  }

}

trait X5LocalStorageComponentImpl extends X5LocalStorageComponent with ComponentWithJDBCHelpers {
  this: X5LocalStorageComponentImpl 
        with X5AgentEssentials =>

  private val storage = new X5LocalStorageImpl
  def x5storage = storage

  class X5LocalStorageImpl 
    extends X5LocalStorage
    with JDBCHelpers {

    def x5dbFileName = x5dirName + "/" + userName + ".derby"

    override protected def connectionString = "jdbc:derby:"+x5dbFileName+";create=true"

    def start = {
      val p = System.getProperties
      p.put("derby.stream.error.method", "com.xored.x5agent.core.DerbyUtil.errorStream")

      val driverName = "org.apache.derby.jdbc.EmbeddedDriver"
      Class.forName(driverName).newInstance()

      databaseVersion match {
        case None => { logInfo("No database found at "+x5dbFileName+", creating a new one"); createDb }
        case _ => { logInfo("Using database at "+x5dbFileName) } //TODO: FUTURE VERSIONS: check version and upgrade if needed
      }

      logInfo("X5 agent storage is started")
    } 

    def stop = {
      //TRICKY: A clean shutdown always throws SQL exception XJ015, which can be ignored.
      try {
        DriverManager.getConnection("jdbc:derby:"+x5dbFileName+";shutdown=true")
      } catch {
        case _ => {}
      }
      logInfo("X5 agent storage is shutted down")
    } 

    def databaseVersion:Option[String] =
      withConnection (c=>{
        // TRICKY: table name patterns are case sensitive and Derby thinks it is uppercase
        withResultSet(c.meta.tables(tableNamePattern=Some("VERSION")), trs=>{
          val exists = trs.foldLeft(false)((_,_)=>true)
          logDebug("exists "+exists)
          if (!exists) None
          else executeQuery(c<<"SELECT VALUE FROM VERSION", rs=>rs.foldLeft(None:Option[String])((_,_)=>rs.nextString))
        })
      })

    def save(r:Report):Unit = 
      withConnection (c=>{
        execute( c << "INSERT INTO REPORTS (CONTENT, CREATED_AT, SUBMITTED_AT, REMOTE_ID) values (?,?,?,?)" << 
                r.content << r.createdAt << r.submittedAt << r.remoteId )
        })

    def unsent(maxNumber:Int):List[Report] =
      withConnection (c=>{
        executeQuery( c << 
          "SELECT ID, CONTENT, CREATED_AT, SUBMITTED_AT, REMOTE_ID "+
          "FROM REPORTS WHERE submitted_at IS NULL" max(maxNumber)
          ,rs => { rs.map( r=>Report(r,r.nextString.get,r.nextDate.get,r,r) ) } )
        })

    def markAsSent(id:Int, at:Date, remoteId:String):Unit =
      withConnection (c=>{
        execute( c <<
          "UPDATE REPORTS SET SUBMITTED_AT=?, REMOTE_ID=? WHERE ID=?"<< at << remoteId << id
        )
      })
    
    private def createDb:Unit = executeScript( resource("/init.sql") )

    private def resource(name:String):Source = Source.fromInputStream( this.getClass.getResourceAsStream(name) )

  }

}
