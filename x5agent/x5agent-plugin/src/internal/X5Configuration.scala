package com.xored.x5agent.core.internal

import java.util.Properties
import java.io.{File, FileOutputStream, FileInputStream}

trait X5ConfigurationComponent {
  this: 
    X5ConfigurationComponent 
    with X5AgentEssentials =>

  def x5config:X5Configuration

  trait X5Configuration {
    def lastConfiguredURL:Option[String]
    def url:Option[String]
    def setURL(url:String)
  }

}

trait X5ConfigurationComponentImpl extends X5ConfigurationComponent {
  this: 
    X5ConfigurationComponentImpl 
    with X5AgentEssentials =>

  override def x5config = X5ConfigurationImpl

  object X5ConfigurationImpl extends X5Configuration {

    val lastConfigDirName = userHome match {
      case null => { logError("Can't find user home folder location, so last configuration details are disabled"); null }
      case x => x + ".x5agent/"
    }

    val lastConfigDir:File =
      lastConfigDirName match {
        case null => null
        case x => new File(x)
      }

    val lastConfigDirFound = 
      try { lastConfigDir match {
        case null => false
        case f => { f.mkdirs(); true }
      } } catch {
        case t => { logError("Can't create /.x5agent/ in user home. Last configuration details are disabled. Reason:")
                    t.printStackTrace(); false }
      }

    val lastConfigFileName = 
      lastConfigDirName match {
        case null => null
        case x => x + "config.properties"
      }

    val lastConfigFile =
      lastConfigFileName match {
        case null => null
        case x => new File(x)
      }

    val configFileName = 
      x5dirName match {
        case null => null
        case x => x + userName + "-config.properties"
      }

    val configFile =
      configFileName match {
        case null => null
        case x => new File(x)
      }

    val lastConfigEnabled = (lastConfigFile != null)
    val configEnabled = (configFile != null)

    private val URL_KEY = "x5.url"

    var _lastUrl:Option[String] = try { 
      if(lastConfigEnabled && lastConfigFile.exists) read(lastConfigFile)
      else None
    } catch {
      case t => { logError("Exception is thrown while reading configuration", t); None }
    }

    var _url:Option[String] = try {
      if (configEnabled && configFile.exists) read(configFile)
      else None
    } catch {
      case t => { logError("Exception is thrown while reading configuration", t); None }
    }


    private def read(file:File):Option[String] = {
      val p = new Properties()
      p.load(new FileInputStream(file))
      p.getProperty(URL_KEY) match {
        case null => None
        case x => Some(x)
      }
    } 

    def lastConfiguredURL:Option[String] = _lastUrl

    def url:Option[String] = _url
    
    def setURL(url:String):Unit = {
      try {
        val p = new Properties()
        p.setProperty(URL_KEY, url)

        if (configEnabled) {
          p.store(new FileOutputStream(configFile), "X5 Agent configuration") 
          logDebug("Updated configuration file "+configFile)
        } else logError("Can't save the X5 url because configuration service is disabled because of previous errors")

        if (lastConfigEnabled) {
          p.store(new FileOutputStream(lastConfigFile), "last configured X5 location")
          logDebug("Updated last config file "+lastConfigFile)
        } else logError("Can't save the X5 url because configuration service is disabled because of previous errors")

      } catch {
        case t => logError("Exception is thrown while saving a configuration", t)
      }
      //--- and finally
      _url = Some(url)
      _lastUrl = Some(url)
    }

  }

}
