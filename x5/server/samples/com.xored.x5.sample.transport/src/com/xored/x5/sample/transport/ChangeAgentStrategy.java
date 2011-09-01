package com.xored.x5.sample.transport;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.x5.agent.AgentStrategy;
import com.xored.x5.core.EObjectQueue;

public class ChangeAgentStrategy implements AgentStrategy {

	@Override
	public void prepare(EObject object) {
		new ChangeRecorder(object) {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				endRecording();
				beginRecording(new ArrayList<EObject>());
				queue.push(summarize());
			}
		};
		queue.push(EcoreUtil.copy(object));
	}

	@Override
	public void push(EObject object) {
	}

	@Override
	public void initialize(EObjectQueue queue) {
		this.queue = queue;
	}

	private EObjectQueue queue;

}