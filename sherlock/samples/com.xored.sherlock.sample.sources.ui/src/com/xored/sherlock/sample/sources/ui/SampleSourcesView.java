package com.xored.sherlock.sample.sources.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.sample.sources.Sample;
import com.xored.sherlock.sample.sources.SourcesFactory;

public class SampleSourcesView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Group event = new Group(parent, SWT.NONE);
		event.setText("Event");
		event.setLayout(new GridLayout(3, false));
		event.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label eventLabel = new Label(event, SWT.LEFT);
		eventLabel.setText("Sample text: ");
		eventText = new Text(event, SWT.BORDER);
		eventText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button eventButton = new Button(event, SWT.PUSH);
		eventButton.setText("Push event");
		eventButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Sample sample = SourcesFactory.eINSTANCE.createSample();
				sample.setText(eventText.getText());
				SampleRegistry.getInstance().fireEvent(sample);
			}
		});

		Group interval = new Group(parent, SWT.NONE);
		interval.setText("Interval");
		interval.setLayout(new GridLayout(3, false));
		interval.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label intervalLabel = new Label(interval, SWT.LEFT);
		intervalLabel.setText("Sample text: ");
		final Text intervalText = new Text(interval, SWT.BORDER);
		intervalText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final Button intervalButton = new Button(interval, SWT.PUSH);
		intervalButton.setText("Start");

		intervalButton.addSelectionListener(new SelectionAdapter() {

			private boolean active;

			@Override
			public void widgetSelected(SelectionEvent e) {
				Sample sample = SourcesFactory.eINSTANCE.createSample();
				sample.setText(intervalText.getText());
				if (active) {
					SampleRegistry.getInstance().fireProcessEnd(sample);
					intervalButton.setText("Start");
				} else {
					SampleRegistry.getInstance().fireProcessStart(sample);
					intervalButton.setText("End");
				}
				active = !active;
			}
		});
	}

	@Override
	public void setFocus() {
		eventText.setFocus();
	}

	private Text eventText;

}
