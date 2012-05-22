package com.own.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Base exception for the class. Each exception condition will be marked by an
 * error code.Basic classes coming in as Object (List,String, String[])
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
		LOG, VIEW, ALL
	}

	private static final long serialVersionUID = 1L;
	private Map<ExceptionType, Map<Integer, List<Object>>> errorMap = new HashMap<BaseException.ExceptionType, Map<Integer, List<Object>>>();

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

	protected BaseException(
			Map<ExceptionType, Map<Integer, List<Object>>> errorMap, Throwable e) {
		super(e);
		this.errorMap = errorMap;
	}

	@SuppressWarnings("unchecked")
	public BaseException(ExceptionType view,
			@SuppressWarnings("rawtypes") Map response, Throwable throwable) {
		super(throwable);
		this.errorMap.put(view, ((Map<Integer, List<Object>>) response));
	}

	public abstract BaseException addErrorCode(ExceptionType type,
			Integer errorCode, Object element);

	protected void appendErrorCode(ExceptionType type, Integer errorCode,
			Object element) {

		if (null == element)
			element = DEFAULT_ELEMENT;
		Map<Integer, List<Object>> mapper = errorMap.get(type);
		if (null == mapper) {
			mapper = new HashMap<Integer, List<Object>>();

		}
		List<Object> list = mapper.get(errorCode);
		if (null == list) {
			list = new ArrayList<Object>();
		}
		list.add(element);
		mapper.put(errorCode, list);
		errorMap.put(type, mapper);
	}

	public Map<Integer, List<Object>> getErrorMessages(ExceptionType type) {
		Map<Integer, List<Object>> mapper = errorMap.get(type);
		if (null == mapper) {
			mapper = new HashMap<Integer, List<Object>>();
		}
		return mapper;

	}

	public Map<Integer, List<Object>> getAllErrorMessages(ExceptionType type) {

		Set<ExceptionType> keySet = new HashSet<BaseException.ExceptionType>();
		if (type.equals(ExceptionType.ALL)) {
			keySet = this.errorMap.keySet();
		} else {
			keySet.add(type);
		}

		return getErrorMessage(keySet);
	}

	private Map<Integer, List<Object>> getErrorMessage(
			Set<ExceptionType> typeSet) {
		Map<Integer, List<Object>> messages = new HashMap<Integer, List<Object>>();
		for (ExceptionType type : this.errorMap.keySet()) {
			Map<Integer, List<Object>> errorByType = this.errorMap.get(type);
			messages.putAll(errorByType);
		}
		return messages;
	}

	public Map<ExceptionType, Map<Integer, List<Object>>> getErrorMessages() {
		return this.errorMap;
	}

}
