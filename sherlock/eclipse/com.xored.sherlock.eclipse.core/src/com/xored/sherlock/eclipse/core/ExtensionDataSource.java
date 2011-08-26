package com.xored.sherlock.eclipse.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.xored.sherlock.core.DataSource;

/**
 * <p>
 * A generic implementation of <code>DataSource</code> that takes advantage of
 * the <code>IExecutableExtension</code> mechanism. The data source options can
 * be specified purely in XML. This can be done as follows:
 * </p>
 * <pre>
 * <code>
 *  &lt;source id="sourceId" class="my.custom.dataSource"&gt;
 *    &lt;parameter name="key1" value="value1" /&gt;
 *    &lt;parameter name="key2" value="value2" /&gt;
 *  &lt;/source&gt; 
 * </code>
 * or:
 * <code>
 *  &lt;source id="sourceId" class="my.custom.dataSource:key1=value1;key2=value2" /&gt;
 * </code>
 * </pre>
 * 
 * @author Yuri Strot
 */
public abstract class ExtensionDataSource implements IExecutableExtension, DataSource {

	protected void doInitialize(Map<String, String> options) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (data instanceof String) {
			final StringTokenizer tokenizer = new StringTokenizer((String) data, ";");
			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken().trim();
				if (token.length() > 0) {
					String[] pair = token.split("=");
					if (pair == null || pair.length != 2) {
						throw new CoreException(
								new Status(IStatus.ERROR, SherlockCore.PLUGIN_ID,
										"Initialization data should be specified in the following format: '<key1>=<value1>; <key2>=<value2>; ...'"));
					}
					baseOptions.put(pair[0].trim(), pair[1].trim());
				}
			}
		} else if (data instanceof Hashtable) {
			baseOptions.putAll((Hashtable<String, String>) data);
		}
	}

	@Override
	public final void initialize(Map<String, String> options) {
		Map<String, String> base = Collections.emptyMap();
		if (!baseOptions.isEmpty()) {
			base.putAll(baseOptions);
		}
		base.putAll(options);
		doInitialize(options);
	}

	private Map<String, String> baseOptions = new HashMap<String, String>();

}
