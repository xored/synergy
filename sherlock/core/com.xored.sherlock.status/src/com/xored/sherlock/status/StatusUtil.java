package com.xored.sherlock.status;

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

}
