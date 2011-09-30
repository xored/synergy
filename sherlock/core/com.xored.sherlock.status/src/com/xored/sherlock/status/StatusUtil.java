package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class StatusUtil {

	public static boolean isOk(Status status) {
		return status.getSeverity() == Severity.OK;
	}

	public static Status newOkStatus() {
		return newOkStatus("unknown");
	}

	public static Status newOkStatus(String target) {
		Status status = StatusFactory.eINSTANCE.createStatus();
		status.setTarget(target);
		return status;
	}

	public static Status newErrorStatus(String target, Exception e) {
		return newErrorStatus(target, e, e.getMessage());
	}

	public static Status newErrorStatus(String target, String message) {
		return newErrorStatus(target, null, message);
	}

	public static Status newErrorStatus(String target, Exception e, String message) {
		Status status = newOkStatus(target);
		status.setSeverity(Severity.ERROR);
		if (message == null && e != null) {
			message = e.getMessage();
		}
		status.setMessage(message);
		if (e != null) {
			status.setException(ExceptionUtil.convert(e));
		}
		return status;
	}

	public static void print(Status status, PrintStream s) {
		synchronized (s) {
			print(0, status, new TextPrinter.Stream(s));
		}
	}

	public static void print(Status status, PrintWriter s) {
		synchronized (s) {
			print(0, status, new TextPrinter.Writer(s));
		}
	}

	private static void print(int depth, Status status, TextPrinter priner) {
		printStatus(depth, status, priner);
		printMessage(status, priner);
		printStack(status, priner);

		for (Status child : status.getChildren()) {
			print(depth + 1, child, priner);
		}
	}

	private static void printStatus(int depth, Status status, TextPrinter priner) {
		if (depth == 0) {
			priner.println();
			priner.print(ENTRY);
		} else {
			priner.print(SUBENTRY);
			priner.print(SPACE);
			priner.print(Integer.toString(depth));
		}
		priner.print(SPACE);
		priner.print(status.getTarget());
		priner.print(SPACE);
		priner.print(status.getSeverity().toString());
		priner.print(SPACE);
		priner.print(Integer.toString(status.getCode()));
		priner.print(SPACE);
		priner.println(getDate());
	}

	private static void printMessage(Status entry, TextPrinter priner) {
		priner.println(MESSAGE + SPACE + entry.getMessage());
	}

	private static void printStack(Status entry, TextPrinter priner) {
		JavaException e = entry.getException();
		if (e != null) {
			priner.print(STACK);
			priner.println();
			ExceptionUtil.printException(e, priner);
		}
	}

	private static String getDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		StringBuffer sb = new StringBuffer();
		appendPaddedInt(c.get(Calendar.YEAR), 4, sb).append('-');
		appendPaddedInt(c.get(Calendar.MONTH) + 1, 2, sb).append('-');
		appendPaddedInt(c.get(Calendar.DAY_OF_MONTH), 2, sb).append(' ');
		appendPaddedInt(c.get(Calendar.HOUR_OF_DAY), 2, sb).append(':');
		appendPaddedInt(c.get(Calendar.MINUTE), 2, sb).append(':');
		appendPaddedInt(c.get(Calendar.SECOND), 2, sb).append('.');
		appendPaddedInt(c.get(Calendar.MILLISECOND), 3, sb);
		return sb.toString();
	}

	private static StringBuffer appendPaddedInt(int value, int pad, StringBuffer buffer) {
		pad = pad - 1;
		if (pad == 0)
			return buffer.append(Integer.toString(value));
		int padding = (int) Math.pow(10, pad);
		if (value >= padding)
			return buffer.append(Integer.toString(value));
		while (padding > value && padding > 1) {
			buffer.append('0');
			padding = padding / 10;
		}
		buffer.append(value);
		return buffer;
	}

	private static final String ENTRY = "!ENTRY"; //$NON-NLS-1$
	private static final String SUBENTRY = "!SUBENTRY"; //$NON-NLS-1$
	private static final String MESSAGE = "!MESSAGE"; //$NON-NLS-1$
	private static final String STACK = "!STACK"; //$NON-NLS-1$
	private static final String SPACE = " "; //$NON-NLS-1$

}
