package com.xored.x5.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xored.sherlock.status.Status;

public class DefaultLog implements Log {

	public static final DefaultLog INSTANCE = new DefaultLog();

	private DefaultLog() {
	}

	@Override
	public void log(Status status) {
		String time = SimpleDateFormat.getDateTimeInstance().format(new Date());
		synchronized (System.out) {
			System.out.println("[" + status.getSeverity().getLiteral() + "] " + status.getTarget() + " " + time);
			System.out.println(status.getMessage());
		}
	}

}
