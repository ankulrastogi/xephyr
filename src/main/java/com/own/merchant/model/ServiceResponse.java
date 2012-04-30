package com.own.merchant.model;

import java.util.Map;

public class ServiceResponse {

	private String responseCode;
	
	private Map<String,String> errorMap;
	
	private Object response;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Map<String,String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String,String> errorMap) {
		this.errorMap = errorMap;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
