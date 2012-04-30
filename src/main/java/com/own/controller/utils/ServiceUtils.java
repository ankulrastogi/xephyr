package com.own.controller.utils;

import java.util.Map;

import com.own.merchant.model.ServiceResponse;

public class ServiceUtils {


	public static ServiceResponse composeServiceResponse(String respCode,
			Map<String, String> errorMessage, Object response) {

		ServiceResponse sResponse = new ServiceResponse();
		sResponse.setResponse(response);
		sResponse.setErrorMap(errorMessage);
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
