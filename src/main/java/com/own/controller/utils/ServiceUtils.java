package com.own.controller.utils;

import java.util.HashMap;
import java.util.Map;

import com.own.merchant.model.ServiceResponse;

public class ServiceUtils {


	public static ServiceResponse composeServiceResponse(String respCode,
			Map<String, String> errorMessage, Object response) {

		ServiceResponse sResponse = new ServiceResponse();
		sResponse.setResponseCode(respCode);
		sResponse.setErrorMap(errorMessage);
		sResponse.setResponse(response);
		return sResponse;

	}
	
	public static ServiceResponse composeServiceResponse(String respCode,
			String errorMessage, Object response) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("ERROR", errorMessage);
		ServiceResponse sResponse = new ServiceResponse();
		sResponse.setResponseCode(respCode);
		sResponse.setErrorMap(errorMap);
		sResponse.setResponse(response);
		return sResponse;

	}

	/**
	 * This method compares two strings and checks if both are equal or not
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean compareString(String one, String two) {
		return false;
	}

}
