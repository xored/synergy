package com.xored.sherlock.ui.reportdetails.figures;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.xored.sherlock.core.model.sherlock.report.EventSource;

public class SourceFigure extends RectangleFigure {
	private RectangleFigure container;
	private Label title;
	private EventSource source;

	public SourceFigure(String name, int timeWidth, int len) {
		GridLayout gl = new GridLayout(2, false);
		gl.horizontalSpacing = 0;
		gl.verticalSpacing = 0;
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		setLayoutManager(gl);

		title = new Label(" " + name);
		GridData gd = new GridData(300, 20);
		// gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.TOP;
		gd.horizontalAlignment = SWT.LEFT;
		add(title);
		title.setLabelAlignment(PositionConstants.LEFT);
		gl.setConstraint(title, gd);

		container = new RectangleFigure();
		container.setLayoutManager(new XYLayout());
		add(container);

		gl.setConstraint(container, new GridData(timeWidth + 4, 24 * len));
	}

	public void addToContainer(IFigure figure, int x, int y, int width,
			int height, int pos) {
		container.add(figure);
		if (width == 0) {
			width = 1;
		}
		figure.setBounds(new Rectangle(2 + x, 4 + y + 24 * pos, width,
				height - 2));
	}

	public boolean hasChildInContainer() {
		return !container.getChildren().isEmpty();
	}

	public Label getTitle() {
		return title;
	}

	public void setSource(EventSource source) {
		this.source = source;
	}
}
