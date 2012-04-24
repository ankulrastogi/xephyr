package com.own.controller.utils;

import java.util.Arrays;

import com.own.merchant.model.ServiceResponse;

public class ServiceUtils {

	public static ServiceResponse composeServiceResponse(String respCode, String[] errorCodes,
			Object response) {
		
		ServiceResponse sResponse = new ServiceResponse();
		sResponse.setResponse(response);
		sResponse.setErrorCode(Arrays.asList(errorCodes));
		sResponse.setResponse(response);
		return sResponse;
		
	}

}
