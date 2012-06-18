package com.pg.controller.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.pg.common.constant.AppConstant;
import com.pg.controller.factory.MessageConvertorFactory;

public class BaseController {

	private final String REDIRECT = "redirect:";

	@Autowired
	protected MessageConvertorFactory convertorfactory;

	protected String getInternalRedirect(String controllerName) {

		return REDIRECT + controllerName;
	}

	protected String getInternalRedirect(String controllerName,
			String queryString) {

		return REDIRECT + controllerName + "?" + queryString;
	}


	private String convertToQueryString(final Map<String, String[]> paramMap) {

		StringBuffer buffer = new StringBuffer();
		for (String key : paramMap.keySet()) {
			for (String element : paramMap.get(key)) {
				buffer.append(key).append("=").append(element).append("&");
			}
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
	}

	protected String getInternalRedirectView(final HttpServletRequest request,
			final String controllerPath, final Map<String, String> param) {

		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = new HashMap<String, String[]>(
				request.getParameterMap());

		// see if any element is to be updated in parameter Map. If its null
		// then simply ignore it
		if (null != param) {
			for (String key : param.keySet()) {
				parameterMap.put(key, new String[] { param.get(key) });
			}

		}

		String queryString = convertToQueryString(parameterMap);

		return getInternalRedirectView(controllerPath, queryString);
	}

	protected String getInternalRedirectView(final String name,
			final String queryString) {
		if (null == queryString) {
			return getInternalRedirectView(name);
		}
		return new StringBuilder().append(AppConstant.REDIRECT).append(name)
				.append("?").append(queryString).toString();

	}

	protected String getInternalRedirectView(final String name) {
		return new StringBuilder().append(AppConstant.REDIRECT).append(name)
				.toString();

	}
}
