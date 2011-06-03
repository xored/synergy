package com.xored.x5agent.core

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

import com.xored.sherlock.core._
import com.xored.x5agent.core.internal._

import org.eclipse.core.runtime._
import org.eclipse.ui.IStartup

/**
 * The activator class controls the plug-in life cycle
 */
class X5AgentCorePlugin 
  extends AbstractUIPlugin 
  with X5ListenerComponentImpl
  with X5LocalStorageComponentImpl
  with X5HttpDispatcherComponentImpl
  with X5HttpSubmitterComponentImpl
  with X5ConfigurationComponentImpl
  with EclipseX5AgentEssentials {
    // The plug-in ID
  val PLUGIN_ID = "com.xored.x5agent.core"

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  override def start(context: BundleContext) {
    super.start(context)
    X5AgentCorePlugin.plugin = this

    wrapExceptions {
      onStart
      x5storage.start
      /* IStatusFilter IPluginFilter */
      SherlockCore.addLogListener(x5listener, null, null)
  
      logInfo("started X5 Agent plugin")
    }
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  override def stop(context: BundleContext) {
    wrapExceptions {
      SherlockCore.removeLogListener(x5listener)
      x5storage.stop
    }

    X5AgentCorePlugin.plugin = null
    super.stop(context)
  }
  
  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  def getDefault() {
    return X5AgentCorePlugin.plugin
  }

}

object X5AgentCorePlugin {
  // The shared instance
  private var plugin: X5AgentCorePlugin = _

}

/* startup */
class X5AgentStartup 
  extends IStartup {

  def earlyStartup():Unit = {
    /* nothing, we just need it to start listening to the Eclipse logs */ 
  }
}

