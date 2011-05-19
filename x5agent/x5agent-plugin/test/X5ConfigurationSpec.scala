package com.xored.x5agent.core.internal

import org.specs2._
import java.io.File
import java.util.Date

class X5LocalConfigurationSpec extends SpecificationWithJUnit { def is =

  "This is a specification to check the X5 configuration service"             ^
                                                                                p^
  "X5 agent configuration should"                                             ^
    "return None for url when nothing is configured yet"                      ! noURL ^
    "return None for last url when nothing is configured yet"                 ! noLastURL ^
    "successfully set url"                                                    ! setURL ^
    "update last url after setting the new one"                               ! updatedLastURL ^
                                                                              end

  object ConfigurationComponent 
    extends X5ConfigurationComponentImpl 
    with TestX5AgentEssentials{}
  
  def noURL = 
    ConfigurationComponent.x5config.url must beNone

  def noLastURL = 
    ConfigurationComponent.x5config.lastConfiguredURL must beNone

  def setURL = {
    ConfigurationComponent.x5config.setURL("http://localhost:8080/")
    ConfigurationComponent.x5config.url must beSome("http://localhost:8080/")
  }

  def updatedLastURL = 
    ConfigurationComponent.x5config.lastConfiguredURL must beSome("http://localhost:8080/")

}
