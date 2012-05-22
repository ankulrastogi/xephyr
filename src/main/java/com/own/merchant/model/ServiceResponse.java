package com.own.merchant.model;

import java.util.List;
import java.util.Map;

public class ServiceResponse {

	private String responseCode;
	
	private Map<String,List<String>> errorMap;
	
	private Object response;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Map<String,List<String>> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String,List<String>> errorMap) {
		this.errorMap = errorMap;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
