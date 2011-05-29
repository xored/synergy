package com.xored.x5agent.core.internal

import com.xored.x5agent.core._
import org.specs2._
import java.io.File
import java.util.Date

class X5LocalConfigurationTest extends SpecificationWithJUnit { def is =

  "This is a specification to check the X5 configuration service"             ^
                                                                                p^
  "X5 agent configuration should"                                             ^
    "return configuration even when nothing is configured yet"                ! noURL ^
    "return None for last url when nothing is configured yet"                 ! noLastURL ^
    "successfully set url"                                                    ! setURL ^
    "update last url after setting the new one"                               ! updatedLastURL ^
                                                                              end

  object ConfigurationComponent 
    extends X5ConfigurationComponentImpl 
    with TestX5AgentEssentials{}
  
  def noURL = 
    ConfigurationComponent.x5config.configuration must not beNull

  def noLastURL = 
    ConfigurationComponent.x5config.lastConfiguration must beNone

  def setURL = {
    ConfigurationComponent.x5config.setConfiguration(Configuration("http://localhost:8080/","tag"))
    ConfigurationComponent.x5config.configuration must beEqualTo(Configuration("http://localhost:8080/","tag"))
  }

  def updatedLastURL = 
    ConfigurationComponent.x5config.lastConfiguration.isDefined must beTrue

}
