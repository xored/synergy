package com.xored.x5.sample.agent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class SampleAgentView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		text = new Text(parent, SWT.BORDER);
	}

	@Override
	public void setFocus() {
		text.setFocus();
	}

	private Text text;

}
