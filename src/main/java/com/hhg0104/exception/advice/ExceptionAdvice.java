package com.hhg0104.exception.advice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hhg0104.exception.SessionElementException;

@ControllerAdvice(basePackages = "com.hhg0104.*")
public class ExceptionAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler(SessionElementException.class)
	public ResponseEntity<Map<String, String>> handleSessionElementException(SessionElementException ex) {

		LOGGER.error(ex.getMessage());

		Map<String, String> errorMap = getErrorMap(ex.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, ex.getCode());
	}

	private Map<String, String> getErrorMap(String message) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("message", message);

		return errorMap;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception ex) {

		LOGGER.error(ex.getMessage());

		Map<String, String> errorMap = getErrorMap(ex.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
