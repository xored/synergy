package com.xored.x5agent.ui

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

import org.eclipse.core.runtime._
/**
 * The activator class controls the plug-in life cycle
 */
class X5AgentUIPlugin 
  extends AbstractUIPlugin { 
  // The plug-in ID
  val PLUGIN_ID = "com.xored.x5agent.ui"

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  override def start(context: BundleContext) {
    super.start(context)
    X5AgentUIPlugin.plugin = this
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  override def stop(context: BundleContext) {
    X5AgentUIPlugin.plugin = null
    super.stop(context)
  }
  
  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  def getDefault() {
    return X5AgentUIPlugin.plugin
  }

}

object X5AgentUIPlugin {
  // The shared instance
  private var plugin: X5AgentUIPlugin = _

}
