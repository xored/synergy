package com.xored.x5agent.core.internal

import java.util.Properties
import java.util.UUID
import com.xored.x5agent.core.Configuration
import java.io.{File, FileOutputStream, FileInputStream}

trait X5ConfigurationComponent {
  this: 
    X5ConfigurationComponent 
    with X5AgentEssentials =>

  def x5config:X5Configuration

  trait X5Configuration {
    def lastConfiguration:Option[Configuration]

    def configuration:Configuration
    def setConfiguration(cfg:Configuration)
    def instanceId:String
  }

}

trait X5ConfigurationComponentImpl extends X5ConfigurationComponent {
  this: 
    X5ConfigurationComponentImpl 
    with X5AgentEssentials =>

  override def x5config = X5ConfigurationImpl

  object X5ConfigurationImpl extends X5Configuration {
    private val DEFAULT_URL = "http://x5.xored.com"
    private val DEFAULT_SOURCE = "default"
    private val DEFAULT_CONFIG = Configuration(DEFAULT_URL, DEFAULT_SOURCE)

    private val URL_KEY = "x5.url"
    private val SOURCE_KEY = "x5.source"
    private val INSTANCE_KEY = "x5.instance"


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

    var (_config:Configuration, _instanceId:String) = 
      if (configEnabled) {
        if (!configFile.exists) {
          logInfo("No configuration found, assuming defaults")  
          fallbackToDefaults
        } else read(configFile) match {
            case (Some(cfg),Some(i)) => (cfg,i)
            case _ => fallbackToDefaults
          }
      } else fallbackToDefaults

    private def fallbackToDefaults = {
      var id = UUID.randomUUID().toString 
      logInfo("Assigned instanceId is "+id)
      save(DEFAULT_CONFIG, id, false)
      (DEFAULT_CONFIG, id)
    }

    var _lastConfig:Option[Configuration] = try { 
      if(lastConfigEnabled && lastConfigFile.exists) read(lastConfigFile)._1
      else None
    } catch {
      case t => { logError("Exception is thrown while reading configuration", t); None }
    }

    private def read(file:File):Tuple2[Option[Configuration],Option[String]] = {
      val p = new Properties()
      p.load(new FileInputStream(file))
      val url:Option[String] = opt (p.getProperty(URL_KEY))
      val source:Option[String] = opt (p.getProperty(SOURCE_KEY))
      val instanceId:Option[String] = opt (p.getProperty(INSTANCE_KEY))
      ( (url, source) match {
          case (Some(u), Some(s)) => Some(Configuration(u,s))
          case _ => None
        }, instanceId )
    } 
    private def opt[A >:Null](x:A):Option[A] = 
      x match {
        case null => None
        case _ => Some(x)
      }

    override def lastConfiguration:Option[Configuration] = _lastConfig
    override def configuration:Configuration = _config
    override def instanceId = _instanceId
    override def setConfiguration(cfg:Configuration) = save(cfg, _instanceId)
    
    def save(cfg:Configuration, instanceId:String, updateLast:Boolean = true):Unit = {
      try {
        val current = new Properties()
        current.setProperty(URL_KEY, cfg.url)
        current.setProperty(SOURCE_KEY, cfg.source)
        current.setProperty(INSTANCE_KEY, instanceId)
        val last = new Properties()
        last.setProperty(URL_KEY, cfg.url)
        last.setProperty(SOURCE_KEY, cfg.source)

        if (configEnabled) {
          current.store(new FileOutputStream(configFile), "X5 Agent configuration") 
          logDebug("Updated configuration file "+configFile)
        } else logError("Can't save the X5 agent settings because configuration service is disabled because of previous errors")

        if (lastConfigEnabled && updateLast) {
          last.store(new FileOutputStream(lastConfigFile), "last configured X5 properties")
          logDebug("Updated last config file "+lastConfigFile)
        } else if (updateLast) logError("Can't save the X5 agent settings because configuration service is disabled because of previous errors")

      } catch {
        case t => logError("Exception is thrown while saving a configuration", t)
      }
      //--- and finally
      _config = cfg
      if(updateLast) _lastConfig = Some(cfg)
      _instanceId = instanceId
    }

  }

}
