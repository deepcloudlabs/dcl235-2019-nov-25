package com.example.crm.service.business.exception;

@SuppressWarnings("serial")
public class ExistingCustomerException extends BaseException {
	private final String identity;

	public ExistingCustomerException(String identity, String message, String i18nId, String debugId) {
		super(message, i18nId, debugId);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
}
