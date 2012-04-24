package com.own.merchant.model;

import java.util.List;

public class ServiceResponse {

	private String responseCode;
	
	private List<String> errorCode;
	
	private Object response;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<String> getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(List<String> errorCode) {
		this.errorCode = errorCode;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
