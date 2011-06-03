package com.xored.x5agent.core.internal

import java.sql._
import scala.io.Source
import scala.annotation.tailrec

trait ComponentWithJDBCHelpers {
  this: ComponentWithJDBCHelpers with X5AgentEssentials =>

trait JDBCHelpers {

  implicit def c2rc(c:Connection) = new RichConnection(c)
  implicit def m2rm(m:DatabaseMetaData) = new RichMeta(m)
  implicit def ps2rps(ps:PreparedStatement) = new RichPreparedStatement(ps)
  implicit def rs2rrs(rs:ResultSet) = new RichResultSet(rs)
  implicit def rps2ps(rps:RichPreparedStatement) = rps.ps
  implicit def rrs2rs(rrs:RichResultSet) = rrs.rs

  protected def connectionString:String
  
  protected def withConnection[A](fn : Connection=>A):A = {
    val c = DriverManager.getConnection(connectionString)
    try { fn(c) } finally { 
      try { c.close } catch {
        case t => logError("Exception is thrown while closing the database connection", t)
      }
    }
  }

  protected def execute(stmt:PreparedStatement):Unit = 
    withStatement(stmt, (s:PreparedStatement)=>{ val rs = s.execute })

  protected def executeQuery[A](stmt:PreparedStatement, fn: ResultSet=>A):A = 
    withStatement(stmt, (s:PreparedStatement)=>{
      val rs = s.executeQuery
      withResultSet(rs, fn)
    })

  protected def withStatement[A](stmt:PreparedStatement, fn : PreparedStatement=>A):A =
    try { fn(stmt) } finally {
      try { stmt.close }
      catch {
        case t => logError("Exception is thrown while closing the prepared statement", t)
      }
    }

  protected def withResultSet[A](rs:ResultSet, fn: ResultSet=>A):A =
    try { fn(rs) } 
    finally { 
      try { rs.close }
      catch {
        case t => logError("Exception is thrown while closing the result set", t)
      }
    }

  protected def executeScript(src:Source) = 
    withConnection( c => {
      _executeScript( c, src.getLines.toList )
    })

  @tailrec
  private def _executeScript(c:Connection, src:List[String], acc:List[String] = Nil):Unit = 
    src match {
      case head::tail =>
        if (head.trim.endsWith(";")) {
          executeStatement(c, (head::acc).reverse.mkString(" "))
          _executeScript(c, tail)
        } else _executeScript(c, tail, head::acc)
      case Nil => executeStatement(c, acc.reverse.mkString(" "))
    }

  private def executeStatement(c:Connection, statement:String): Unit = {
    val trimmed = statement.trim
    val baked = trimmed.reverse.dropWhile(_ == ';').reverse

    if (!baked.isEmpty) { 
      logDebug("executing: "+baked)
      withStatement( c << baked, stmt=>{stmt<<!} )
    }
  }

  class RichConnection(val connection:Connection) {
    def <<(str:String) = connection.prepareStatement(str)

    def meta = connection.getMetaData
  }

  class RichMeta(val meta:DatabaseMetaData) {

    def tables(catalog:Option[String] = None
              ,schemaPattern:Option[String] = None
              ,tableNamePattern:Option[String] = None
              ,types:Option[scala.Array[String]] = None) = {
      val _catalog = valOrNull(catalog)
      val _schemaPattern = valOrNull(schemaPattern)
      val _tableNamePattern = valOrNull(tableNamePattern)
      val _types = valOrNull(types)

      logDebug("Looking for tables, params are:")
      logDebug("          catalog: "+_catalog)
      logDebug("    schemaPattern: "+_schemaPattern)
      logDebug(" tableNamePattern: "+_tableNamePattern)
      logDebug("            types: "+_types)

      meta.getTables(_catalog,_schemaPattern,_tableNamePattern,_types)
    }

    private def valOrNull[A >: Null](x:Option[A]):A = 
      if (x.isDefined) x.get 
      else null

  }

  class RichPreparedStatement(val ps:PreparedStatement) {
    private var pos = 1

    private def inc = { pos = pos + 1; this}

    def <<[T](x: Option[T])(implicit m: Manifest[T]):RichPreparedStatement =
      x match {
        case None => {
          val erasedName = m.toString
//          logDebug("erasedName "+erasedName)
          ps.setNull(pos,
            erasedName match {
              case "java.lang.String" => Types.VARCHAR
              case "java.util.Date" => Types.TIMESTAMP
              case _ => Types.NULL
            })
          inc
        }
        case Some(y) => (this << y)
      }

    def <<(x:Any):RichPreparedStatement = {
      x match {
        case z:Boolean =>
          ps.setBoolean(pos, z)
        case z:Byte =>
          ps.setByte(pos, z)
        case z:Int =>
          ps.setInt(pos, z)
        case z:Long =>
          ps.setLong(pos, z)
        case z:Float =>
          ps.setFloat(pos, z)
        case z:Double =>
          ps.setDouble(pos, z)
        case z:String =>
          ps.setString(pos, z)
        case z:java.util.Date =>
          ps.setTimestamp(pos, new Timestamp(z.getTime))
        case z => ps.setObject(pos,z)
      }
      inc
    }
    def max(rows:Int) = { ps.setMaxRows(rows); this }

    def <<! = ps.execute

    def <<? = ps.executeQuery
  }

  implicit def rrs2Boolean(rs: RichResultSet):Option[Boolean] = rs.nextBoolean
  implicit def rrs2Byte(rs: RichResultSet):Option[Byte] = rs.nextByte
  implicit def rrs2Int(rs: RichResultSet):Option[Int] = rs.nextInt
  implicit def rrs2Long(rs: RichResultSet):Option[Long] = rs.nextLong
  implicit def rrs2Float(rs: RichResultSet):Option[Float] = rs.nextFloat
  implicit def rrs2Double(rs: RichResultSet):Option[Double] = rs.nextDouble
  implicit def rrs2String(rs: RichResultSet):Option[String] = rs.nextString
  implicit def rrs2Date(rs: RichResultSet):Option[java.util.Date] = rs.nextDate

  class RichResultSet(val rs: ResultSet) {
    var pos = 1
    def apply(i: Int) = { pos = i; this }
 
    def nextBoolean: Option[Boolean] = {val ret = rs.getBoolean(pos); pos = pos + 1; if(rs.wasNull) None else Some(ret) }
    def nextByte: Option[Byte] = { val ret = rs.getByte(pos); pos = pos + 1;  if(rs.wasNull) None else Some(ret) }
    def nextInt: Option[Int] = { val ret = rs.getInt(pos); pos = pos + 1; if(rs.wasNull) None else Some(ret) }
    def nextLong: Option[Long] = { val ret = rs.getLong(pos); pos = pos + 1; if(rs.wasNull) None else Some(ret) }
    def nextFloat: Option[Float] = { val ret = rs.getFloat(pos); pos = pos + 1;  if(rs.wasNull) None else Some(ret) }
    def nextDouble: Option[Double] = { val ret = rs.getDouble(pos); pos = pos + 1;  if(rs.wasNull) None else Some(ret) }
    def nextString: Option[String] = { val ret = rs.getString(pos); pos = pos + 1;  if(rs.wasNull) None else Some(ret) }
    def nextDate: Option[java.util.Date] = { val ret = rs.getTimestamp(pos); pos = pos + 1;  if(rs.wasNull) None else Some(ret) }
 
    def foldLeft[X](init: X)(f: (RichResultSet, X) => X): X = 
      rs.next match {
        case false => init
        case true => { pos = 1 ; foldLeft(f(rs, init))(f) }
      }

    def map[X](f: RichResultSet => X) = {
      var ret = List[X]()
      while (rs.next()) { pos = 1 ; ret = f(this) :: ret }
      ret.reverse // ret should be in the same order as the ResultSet
    }
  } 

}

}
