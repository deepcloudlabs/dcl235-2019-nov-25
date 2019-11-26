package com.example.crm.handler;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crm.dto.RestErrorMessage;
import com.example.crm.service.business.exception.BaseException;

@RestControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(BaseException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestErrorMessage handleCustomerNotFoundException(BaseException e) {
		return new RestErrorMessage(e.getMessage(), e.getI18nId(), e.getDebugId());
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestErrorMessage handleValidationException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("|"));
		return new RestErrorMessage(message, message, "d5d72cb3-5541-4cd9-baec-487cba94c9b8");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String message = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining("|"));
		return new RestErrorMessage(message, message, "d5d72cb3-5541-4cd9-baec-487cba94c9b8");
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public RestErrorMessage handleRuntimeExceptions(RuntimeException e) {
		return new RestErrorMessage(e.getMessage(), e.getMessage(), e.getStackTrace()[0].toString());
	}
}
