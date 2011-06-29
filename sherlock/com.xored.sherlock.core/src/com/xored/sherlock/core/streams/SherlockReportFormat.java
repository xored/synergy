package com.xored.sherlock.core.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.model.sherlock.report.Report;

public class SherlockReportFormat {
	public static void storeReport(Report report, OutputStream stream,
			boolean close) throws IOException {
		SherlockBinaryResourceImpl res = new SherlockBinaryResourceImpl();
		res.getContents().add(EcoreUtil.copy(report));
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(Resource.OPTION_ZIP, Boolean.TRUE);
		res.save(stream, opts);
		if (close) {
			stream.close();
		}
	}

	public static Report loadReport(InputStream stream, boolean close)
			throws IOException {
		SherlockBinaryResourceImpl res = new SherlockBinaryResourceImpl();
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(Resource.OPTION_ZIP, Boolean.TRUE);
		res.load(stream, opts);
		if (close) {
			stream.close();
		}
		if (res.getContents().size() == 1) {
			EObject eObject = res.getContents().get(0);
			if (eObject instanceof Report) {
				return (Report) eObject;
			}
		}
		return null;
	}
}
