package com.xored.x5agent.core.internal

import java.io.OutputStream
import org.apache.commons.httpclient.{HttpClient, HttpStatus}
import org.apache.commons.httpclient.methods.{PostMethod, RequestEntity}

case class HttpError(cause:Throwable)

trait HttpHelpers {
  private val client = new HttpClient
  client.getParams.setParameter("http.useragent", "X5 Agent")

  protected def postJson(url:String, content:String):Either[HttpError,Tuple2[Int,String]] =  {
    val m = postMethod(url)
    m.setRequestEntity(jsonRequestEntity(content))
    try {
      val returnCode = client.executeMethod(m)
      val response = m.getResponseBodyAsString
      Right( (returnCode, response) )
    } catch {
      case t => Left(HttpError(t))
    }
  }

  private def jsonRequestEntity(content:String) = {
    val bytes = content.getBytes("utf-8")
    new RequestEntity {
      override def getContentLength = bytes.length
      override def getContentType = "application/json; charset=utf-8" 
      override def isRepeatable = true
      override def writeRequest(os:OutputStream) = {
        os.write(bytes)
      }
    }
  }

  private def postMethod(url:String) = new PostMethod(url)
  
}
