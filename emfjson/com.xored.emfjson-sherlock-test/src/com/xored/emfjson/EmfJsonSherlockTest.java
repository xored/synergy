package com.xored.emfjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.HashMap;

import com.xored.sherlock.core.model.sherlock.EclipseInfo;
import com.xored.sherlock.core.model.sherlock.EclipsePlugin;
import com.xored.sherlock.core.model.sherlock.SherlockFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonArray;

import org.junit.Test;

public class EmfJsonSherlockTest {

  @Test
  public void testPluginSerialization() throws Exception {
    EclipsePlugin plugin = samplePlugin();

    Emf2Json emf2json = new Emf2Json();
    JsonObject object = emf2json.serialize(plugin);

    assertEquals(object.get("name"), new JsonPrimitive("plugin-name"));
    assertEquals(object.get("provider"), new JsonPrimitive("plugin-provider"));
    assertEquals(object.get("id"), new JsonPrimitive("plugin-id"));
    assertEquals(object.get("version"), new JsonPrimitive("plugin-version"));
  }

  @Test
  public void testEclipseInfoSerialization() throws Exception {
    final EclipseInfo info = sampleInfo();

    Emf2Json emf2json = new Emf2Json();
    JsonObject object = emf2json.serialize(info);
    
    JsonArray plugins = object.getAsJsonArray("plugins");
    assertEquals(10, plugins.size());
    JsonObject fourth = (JsonObject)plugins.get(3);
    
    assertEquals(fourth.get("name"), new JsonPrimitive("plugin-name"));
    assertEquals(fourth.get("provider"), new JsonPrimitive("plugin-provider"));
    assertEquals(fourth.get("id"), new JsonPrimitive("plugin-id"));
    assertEquals(fourth.get("version"), new JsonPrimitive("plugin-version"));
  }

  @Test
  public void testUptimeSerialization() throws Exception {
    final EclipseInfo info = sampleInfo();
    Emf2Json emf2json = new Emf2Json();
    JsonObject object = emf2json.serialize(info);
    JsonElement uptime = object.get("uptime");
    assertTrue("wrong type for uptime: <"+uptime+">", ((JsonPrimitive)uptime).isNumber() );
    assertEquals(uptime, new JsonPrimitive(10000));
  }

  @Test
  public void testEclipseInfoInMapSerialization() throws Exception {
    final EclipseInfo info = sampleInfo();
    Emf2Json emf2json = new Emf2Json();

    JsonObject json = new JsonObject();
    json.add("info", emf2json.serialize(info));

    assertTrue(json.toString().contains("plugin-version"));
  }

  private EclipseInfo sampleInfo() {
    final EclipseInfo info = SherlockFactory.eINSTANCE.createEclipseInfo();
    info.setBuildId("build-id");
    info.setWorkspaceLocation("workspace-location");
    info.setUptime(10000);
    info.setProductId("product-id");
    info.setApplicationId("application-id");
    for (int i=0;i<10;i++) {
      info.getPlugins().add(samplePlugin());
    }
    return info;
  }

  private EclipsePlugin samplePlugin() {
    final EclipsePlugin plugin = SherlockFactory.eINSTANCE.createEclipsePlugin();
    plugin.setName("plugin-name");
    plugin.setProvider("plugin-provider");
    plugin.setId("plugin-id");
    plugin.setVersion("plugin-version");
    return plugin;
  }

}

