/*******************************************************************************
 * Copyright (c) 2010-2013 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Igor Zapletnev)
 *******************************************************************************/
package com.xored.af.ui;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleControlAdapter;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.xored.af.ui.internal.AfUiPlugin;

/**
 * Design and behavior from org.eclipse.ui.dialogs.FilteredTree class
 */
public class SearchControl extends Composite {

    private static final String FilteredTree_ClearToolTip = "Clear";
    private static final String FilteredTree_AccessibleListenerClearButton = "Clear filter field";
    private static final String FilteredTree_FilterMessage = "type filter text";
    /**
     * The filter text widget to be used by this tree. This value may be
     * <code>null</code> if there is no filter widget, or if the controls have
     * not yet been created.
     */
    protected Text filterText;
    /**
     * The control representing the clear button for the filter text entry. This
     * value may be <code>null</code> if no such button exists, or if the
     * controls have not yet been created.
     * <p>
     * <strong>Note:</strong> This is only used if the new look is chosen.
     * </p>
     * 
     * @since 3.5
     */
    protected Control clearButtonControl;
    /**
     * The parent composite of the search control.
     * 
     * @since 3.3
     */
    protected Composite parent;

    private Composite filterComposite;

    private Control searchResultControl;

    /**
     * The text to initially show in the filter text control.
     */
    protected String initialText = ""; //$NON-NLS-1$	

    public SearchControl(final Composite parent) {
        super(parent, SWT.NONE);

        final GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        setLayout(layout);
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        if (useNativeSearchField(parent)) {
            filterComposite = new Composite(this, SWT.NONE);
        } else {
            filterComposite = new Composite(this, SWT.BORDER);
            filterComposite.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        }
        final GridLayout filterLayout = new GridLayout(2, false);
        filterLayout.marginHeight = 1;
        filterLayout.marginWidth = 1;
        filterLayout.marginLeft = 5;
        filterComposite.setLayout(filterLayout);
        filterComposite.setFont(parent.getFont());

        createFilterControls(filterComposite);
        filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
    }

    protected void createFilterControls(final Composite parent) {
        createFilterText(parent);
        createClearText(parent);
        if (clearButtonControl != null) {
            // initially there is no text to clear
            clearButtonControl.setVisible(false);
        }
        setInitialText(FilteredTree_FilterMessage);
    }

    private void createFilterText(final Composite parent) {
        filterText = doCreateFilterText(parent);
        final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);

        if ((filterText.getStyle() & SWT.ICON_CANCEL) != 0)
            gridData.horizontalSpan = 2;
        filterText.setLayoutData(gridData);

        filterText.getAccessible().addAccessibleListener(new AccessibleAdapter() {
            @Override
            public void getName(final AccessibleEvent e) {
                final String filterTextString = filterText.getText();
                if (filterTextString.length() == 0 || filterTextString.equals(initialText)) {
                    e.result = initialText;
                } else {
                    e.result = "";
                }
            }
        });

        filterText.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(final FocusEvent e) {
            }

            @Override
            public void focusLost(final FocusEvent e) {
                if (filterText.getText().equals(initialText)) {
                    setFilterText(""); //$NON-NLS-1$
                    textChanged();
                }
            }
        });

        filterText.addMouseListener(new MouseAdapter() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt
             * .events.MouseEvent)
             */
            @Override
            public void mouseDown(final MouseEvent e) {
                if (filterText.getText().equals(initialText)) {
                    // XXX: We cannot call clearText() due to
                    // https://bugs.eclipse.org/bugs/show_bug.cgi?id=260664
                    setFilterText(""); //$NON-NLS-1$	
                    textChanged();
                }
            }
        });

        filterText.addKeyListener(new KeyAdapter() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt
             * .events.KeyEvent)
             */
            @Override
            public void keyPressed(final KeyEvent e) {
                // on a CR we want to transfer focus to the list

                if (searchResultControl != null && e.keyCode == SWT.ARROW_DOWN) {
                    searchResultControl.setFocus();
                    return;
                }
            }
        });

        // enter key set focus to tree
        filterText.addTraverseListener(new TraverseListener() {
            public void keyTraversed(final TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_RETURN) {
                    e.doit = false;
                    if (searchResultControl != null) {
                        searchResultControl.setFocus();
                    }
                }
            }
        });

        // if we're using a field with built in cancel we need to listen for
        // default selection changes (which tell us the cancel button has been
        // pressed)
        if ((filterText.getStyle() & SWT.ICON_CANCEL) != 0) {
            filterText.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetDefaultSelected(final SelectionEvent e) {
                    if (e.detail == SWT.ICON_CANCEL)
                        clearText();
                }
            });
        }

        filterText.addModifyListener(new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                textChanged();
            }
        });
    }

    protected Text doCreateFilterText(final Composite parent) {
        if (useNativeSearchField(parent)) {
            return new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        }
        return new Text(parent, SWT.SINGLE);
    }

    /**
     * Create the button that clears the text.
     * 
     * @param parent
     *            parent <code>Composite</code> of toolbar button
     */
    private void createClearText(final Composite parent) {
        // only create the button if the text widget doesn't support one
        // natively
        if ((filterText.getStyle() & SWT.ICON_CANCEL) == 0) {
            final Image inactiveImage = (Image) JFaceResources.getResources().get(
                AfUiPlugin.TOOL_SEARCH_CLEAR_DISABLED);
            final Image activeImage = (Image) JFaceResources.getResources().get(AfUiPlugin.TOOL_SEARCH_CLEAR);
            final Image pressedImage = new Image(getDisplay(), activeImage, SWT.IMAGE_GRAY);

            final Label clearButton = new Label(parent, SWT.NONE);
            clearButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
            clearButton.setImage(inactiveImage);
            clearButton.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
            clearButton.setToolTipText(FilteredTree_ClearToolTip);
            clearButton.addMouseListener(new MouseAdapter() {
                private MouseMoveListener fMoveListener;

                @Override
                public void mouseDown(final MouseEvent e) {
                    clearButton.setImage(pressedImage);
                    fMoveListener = new MouseMoveListener() {
                        private boolean fMouseInButton = true;

                        public void mouseMove(final MouseEvent e) {
                            final boolean mouseInButton = isMouseInButton(e);
                            if (mouseInButton != fMouseInButton) {
                                fMouseInButton = mouseInButton;
                                clearButton.setImage(mouseInButton ? pressedImage : inactiveImage);
                            }
                        }
                    };
                    clearButton.addMouseMoveListener(fMoveListener);
                }

                @Override
                public void mouseUp(final MouseEvent e) {
                    if (fMoveListener != null) {
                        clearButton.removeMouseMoveListener(fMoveListener);
                        fMoveListener = null;
                        final boolean mouseInButton = isMouseInButton(e);
                        clearButton.setImage(mouseInButton ? activeImage : inactiveImage);
                        if (mouseInButton) {
                            clearText();
                            filterText.setFocus();
                        }
                    }
                }

                private boolean isMouseInButton(final MouseEvent e) {
                    final Point buttonSize = clearButton.getSize();
                    return 0 <= e.x && e.x < buttonSize.x && 0 <= e.y && e.y < buttonSize.y;
                }
            });
            clearButton.addMouseTrackListener(new MouseTrackListener() {
                public void mouseEnter(final MouseEvent e) {
                    clearButton.setImage(activeImage);
                }

                public void mouseExit(final MouseEvent e) {
                    clearButton.setImage(inactiveImage);
                }

                public void mouseHover(final MouseEvent e) {
                }
            });
            clearButton.addDisposeListener(new DisposeListener() {
                public void widgetDisposed(final DisposeEvent e) {
                    pressedImage.dispose();
                }
            });
            clearButton.getAccessible().addAccessibleListener(new AccessibleAdapter() {
                @Override
                public void getName(final AccessibleEvent e) {
                    e.result = FilteredTree_AccessibleListenerClearButton;
                }
            });
            clearButton.getAccessible().addAccessibleControlListener(new AccessibleControlAdapter() {
                @Override
                public void getRole(final AccessibleControlEvent e) {
                    e.detail = ACC.ROLE_PUSHBUTTON;
                }
            });
            this.clearButtonControl = clearButton;
        }
    }

    /**
     * Get the initial text for the receiver.
     * 
     * @return String
     */
    public String getInitialText() {
        return initialText;
    }

    /**
     * Set the text that will be shown until the first focus. A default value is
     * provided, so this method only need be called if overriding the default
     * initial text is desired.
     * 
     * @param text
     *            initial text to appear in text field
     */
    public void setInitialText(final String text) {
        initialText = text;
        if (filterText != null) {
            filterText.setMessage(text);
            if (filterText.isFocusControl()) {
                setFilterText(initialText);
                textChanged();
            } else {
                getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        if (!filterText.isDisposed() && filterText.isFocusControl()) {
                            setFilterText(initialText);
                            textChanged();
                        }
                    }
                });
            }
        } else {
            setFilterText(initialText);
            textChanged();
        }
    }

    /**
     * Clears the text in the filter text widget.
     */
    protected void clearText() {
        setFilterText(""); //$NON-NLS-1$	
        textChanged();
    }

    /**
     * Set the text in the filter control.
     * 
     * @param string
     */
    protected void setFilterText(final String string) {
        if (filterText != null) {
            filterText.setText(string);
            selectAll();
        }
    }

    /**
     * Select all text in the filter text field.
     * 
     */
    protected void selectAll() {
        if (filterText != null) {
            filterText.selectAll();
        }
    }

    /**
     * Get the filter text for the receiver, if it was created. Otherwise return
     * <code>null</code>.
     * 
     * @return the filter Text, or null if it was not created
     */
    public Text getFilterControl() {
        return filterText;
    }

    /**
     * Convenience method to return the text of the filter control. If the text
     * widget is not created, then null is returned.
     * 
     * @return String in the text, or null if the text does not exist
     */
    public String getFilterString() {
        return filterText != null ? filterText.getText() : null;
    }

    public Control getSearchResultControl() {
        return searchResultControl;
    }

    public void setSearchResultControl(final Control searchResultControl) {
        this.searchResultControl = searchResultControl;
    }

    protected void textChanged() {
        if (clearButtonControl != null) {
            final boolean haveText = (filterText != null) && !filterText.getText().equals("")
                && !filterText.getText().equals(initialText);
            clearButtonControl.setVisible(haveText);
        }
    }

    private static Boolean useNativeSearchField;

    private static boolean useNativeSearchField(final Composite composite) {
        if (useNativeSearchField == null) {
            useNativeSearchField = Boolean.FALSE;
            Text testText = null;
            try {
                testText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
                useNativeSearchField = new Boolean((testText.getStyle() & SWT.ICON_CANCEL) != 0);
            } finally {
                if (testText != null) {
                    testText.dispose();
                }
            }

        }
        return useNativeSearchField.booleanValue();
    }
}
