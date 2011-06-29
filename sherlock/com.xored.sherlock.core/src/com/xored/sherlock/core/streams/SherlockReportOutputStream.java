package com.xored.sherlock.core.streams;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.report.Report;

public class SherlockReportOutputStream {
	private ZipOutputStream stream;
	int index = 0;

	public SherlockReportOutputStream(OutputStream out) {
		this.stream = new ZipOutputStream(out);
	}

	/**
	 * Return access identifier
	 * 
	 * @param report
	 * @return
	 */
	public String write(Report report) {
		String postfix = "";
		if (report.getRoot().getName() != null) {
			postfix = SherlockCore.getID(report.getRoot().getName());
		}
		String id = "" + index + "_" + postfix + ".report";
		ZipEntry entry = new ZipEntry(id);
		index++;
		try {
			stream.putNextEntry(entry);
			SherlockReportFormat.storeReport(report, stream, false);
		} catch (IOException e) {
			SherlockCore.log(e);
			return null;
		}
		return id;
	}

	public void close() {
		try {
			stream.close();
		} catch (IOException e) {
			SherlockCore.log(e);
		}
	}
}