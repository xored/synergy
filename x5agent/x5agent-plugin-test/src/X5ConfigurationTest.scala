package com.xored.x5agent.core.internal

import com.xored.x5agent.core._
import java.io.File
import java.util.Date
import org.junit.Test

class X5LocalConfigurationTest {

  object ConfigurationComponent 
    extends X5ConfigurationComponentImpl 
    with TestX5AgentEssentials{}

  import org.junit.Assert._
 
  @Test 
  def wholeScenario = {
    assertTrue( ConfigurationComponent.x5config.configuration != null )
    assertEquals( None, ConfigurationComponent.x5config.lastConfiguration )
    ConfigurationComponent.x5config.setConfiguration(Configuration("http://localhost:8080/","tag"))
    assertEquals(
      Configuration("http://localhost:8080/","tag")
      ,ConfigurationComponent.x5config.configuration 
    )
    assertTrue (ConfigurationComponent.x5config.lastConfiguration.isDefined)
  }
}
