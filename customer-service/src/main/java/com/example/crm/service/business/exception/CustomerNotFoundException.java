package com.example.crm.service.business.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends BaseException {
	public CustomerNotFoundException(String message, String i18nId, String debugId) {
		super(message, i18nId, debugId);
	}
}
