package com.own.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ErrorManager;

import javassist.bytecode.ExceptionsAttribute;

/**
 * Base exception for the class. Each exception condition will be marked by an
 * error code.
 * 
 * @author ankul
 * 
 */

public abstract class BaseException extends Exception {

	/**
	 * 
	 */

	private final String DEFAULT_ELEMENT = "";

	public enum ExceptionType {
		LOG, VIEW
	}

	private static final long serialVersionUID = 1L;
	private Map<ExceptionType, Map<Integer, Object>> errorMap = new HashMap<BaseException.ExceptionType, Map<Integer, Object>>();

	protected Map<String, String> errorCodes = new HashMap<String, String>();

	protected BaseException(Throwable e) {
		super(e);
	}

	protected BaseException(ExceptionType type, Integer errorCode,
			String message, Throwable e) {
		super(e);
		addErrorCode(type, errorCode, message);
	}

	protected BaseException(ExceptionType type, Integer errorCode, Throwable e) {
		super(e);
		addErrorCode(type, errorCode, DEFAULT_ELEMENT);
	}

	protected BaseException(ExceptionType type, Integer errorCode,
			String[] placeHolders, Throwable e) {
		super(e);
		addErrorCode(type, errorCode, placeHolders);
	}

	protected BaseException(Map<ExceptionType, Map<Integer, Object>> errorMap,
			Throwable e) {
		super(e);
		this.errorMap = errorMap;
	}

	public BaseException(ExceptionType view, Map<Integer, Object> response,
			Throwable throwable) {
		super(throwable);
		this.errorMap.put(view, response);
	}

	public abstract BaseException addErrorCode(ExceptionType type, Integer errorCode,
			Object element);
	
	protected void appendErrorCode(ExceptionType type, Integer errorCode,
			Object element) {

		if (null == element)
			element = DEFAULT_ELEMENT;
		Map<Integer, Object> mapper = errorMap.get(type);
		if (null == mapper) {
			mapper = new HashMap<Integer, Object>();
		}

		mapper.put(errorCode, element);
	}

	public Map<Integer, Object> getErrorMessages(ExceptionType type) {
		Map<Integer, Object> mapper = errorMap.get(type);
		if (null == mapper) {
			mapper = new HashMap<Integer, Object>();
		}
		return mapper;

	}

	public Map<Integer, Object> getAllErrorMessages() {
		Map<Integer, Object> messages = new HashMap<Integer, Object>();

		for (ExceptionType type : this.errorMap.keySet()) {
			Map<Integer, Object> errorByType = this.errorMap.get(type);
			messages.putAll(errorByType);
		}
		return messages;
	}

	public Map<ExceptionType, Map<Integer, Object>> getErrorMessages() {
		return this.errorMap;
	}

}
