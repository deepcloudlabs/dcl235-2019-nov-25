package com.example.crm.dto;

public class RestErrorMessage {

	private String message;
	private String i18nId;
	private String debugId;

	public RestErrorMessage() {
	}

	public RestErrorMessage(String message, String i18nId, String debugId) {
		this.message = message;
		this.i18nId = i18nId;
		this.debugId = debugId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getI18nId() {
		return i18nId;
	}

	public void setI18nId(String i18nId) {
		this.i18nId = i18nId;
	}

	public String getDebugId() {
		return debugId;
	}

	public void setDebugId(String debugId) {
		this.debugId = debugId;
	}

}
