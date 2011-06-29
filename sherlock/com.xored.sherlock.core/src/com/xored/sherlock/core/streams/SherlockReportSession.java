package com.xored.sherlock.core.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.report.Report;

public class SherlockReportSession {
	int index = 0;
	private File root;

	public SherlockReportSession(File root) {
		this.root = root;
		this.root.mkdirs();
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
		String id = "" + String.format("%04d", index) + "_" + postfix
				+ ".report";
		index++;
		try {
			SherlockReportFormat.storeReport(report, new BufferedOutputStream(
					new FileOutputStream(new File(root, id))), true);
		} catch (IOException e) {
			SherlockCore.log(e);
			return null;
		}
		return id;
	}

	public Report getReport(String id) {
		File file = new File(root, id);
		if (!file.exists()) {
			return null;
		}
		try {
			return SherlockReportFormat.loadReport(new BufferedInputStream(
					new FileInputStream(file)), true);
		} catch (IOException e) {
			SherlockCore.log(e);
		}
		return null;
	}

	public void dispose() {
		File[] listFiles = root.listFiles();
		dispose(listFiles);
		root.delete();
	}

	private void dispose(File[] listFiles) {
		if (listFiles == null) {
			return;
		}
		for (File file : listFiles) {
			if (file.isDirectory()) {
				dispose(file.listFiles());
			}
			file.delete();
		}
	}

	public void reinit() {
		dispose();
		root.mkdirs();
	}
}