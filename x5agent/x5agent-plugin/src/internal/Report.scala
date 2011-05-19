package com.xored.x5agent.core.internal

import java.util.Date

case class Report(
  id:Option[Int] = None
  ,content:String
  ,createdAt:Date
  ,submittedAt:Option[Date] = None
  ,remoteId:Option[String] = None
) {}
