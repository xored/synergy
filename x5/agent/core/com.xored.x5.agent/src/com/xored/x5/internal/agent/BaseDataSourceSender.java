package com.xored.x5.internal.agent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.Transport;
import com.xored.x5.common.CommonFactory;
import com.xored.x5.common.DataSourceEntry;
import com.xored.x5.common.PackageEntry;

abstract class BaseDataSourceSender<T extends DataSource> implements DataSourceSender {

	protected BaseDataSourceSender(DataSourceFactory factory, ExecutorService executor) {
		this.factory = factory;
		this.executor = executor;
	}

	public void attachTo(Transport transport) {
		detach();
		this.transport = transport;
		attach();
	}

	public void detach() {
		if (source != null) {
			detachSource(source);
			source = null;
		}
		if (transport != null) {
			transport = null;
		}
	}

	abstract protected void attachSource(T source);

	abstract protected void detachSource(T source);

	protected void push(final EObject data) {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				DataSourceEntry entry = CommonFactory.eINSTANCE.createDataSourceEntry();
				entry.setSource(factory.getId());
				entry.setContent(data);
				transport.send(entry);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void attach() {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				PackageEntry entry = CommonFactory.eINSTANCE.createPackageEntry();
				entry.setSource(factory.getId());
				entry.setContent(EcoreUtil.copy(factory.getEClass().getEPackage()));
				transport.send(entry);
			}
		});
		Map<String, String> options = Collections.emptyMap();
		source = (T) factory.create(options);
		attachSource(source);
	}

	private T source;
	private DataSourceFactory factory;
	private Transport transport;
	private ExecutorService executor;

}
