/*******************************************************************************
 * Copyright (c) 2007 The Eclipse Foundation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    The Eclipse Foundation - initial API and implementation
 *******************************************************************************/
package org.eclipse.epp.usagedata.internal.recording.uploading;


public interface Uploader {
	boolean isUploadInProgress();

	void startUpload();
	
	void addUploadListener(UploadListener listener);
	
	void removeUploadListener(UploadListener listener);

	void setUploadParameters(UploadParameters uploadParameters);
	
	UploadParameters getUploadParameters();
}
