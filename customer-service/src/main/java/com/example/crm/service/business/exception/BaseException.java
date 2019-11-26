package com.example.crm.service.business.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	private final String i18nId;
	private final String debugId;

	public BaseException(String message, String i18nId, String debugId) {
		super(message);
		this.i18nId = i18nId;
		this.debugId = debugId;
	}

	public String getI18nId() {
		return i18nId;
	}

	public String getDebugId() {
		return debugId;
	}
}
