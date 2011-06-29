package com.xored.sherlock.core.streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.report.Report;

public class SherlockReportIterator {
	private ZipInputStream zin;
	ZipEntry currentEntry;
	private File reportFile;

	public SherlockReportIterator(File file) {
		this.reportFile = file;
		reset();
	}

	public void reset() {
		if (zin != null) {
			try {
				zin.close();
			} catch (IOException e) {
				SherlockCore.log(e);
			}
		}
		try {
			this.zin = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(reportFile)));
			currentEntry = zin.getNextEntry();
		} catch (IOException e) {
			SherlockCore.log(e);
		}
	}

	public boolean hasNext() {
		return currentEntry != null;
	}

	public Report next() {
		try {
			Report report = SherlockReportFormat.loadReport(zin, false);
			currentEntry = zin.getNextEntry();
			return report;
		} catch (Throwable e) {
			SherlockCore.log(e);
		}
		return null;
	}

	public void close() {
		currentEntry = null;
		try {
			zin.close();
		} catch (Throwable e) {
			SherlockCore.log(e);
		}
	}

	public File getReportFile() {
		return reportFile;
	}
};
