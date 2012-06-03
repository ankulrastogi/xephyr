package com.own.controller.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.own.common.constants.AppConstant;
import com.own.service.exception.ServiceException;

public class BaseController {

	private final String REDIRECT = "redirect:";
	
	protected String getInternalRedirect(String controllerName)
	{
		
		return REDIRECT + controllerName;
	}
	
	protected String getInternalRedirect(String controllerName,String queryString)
	{
		
		return REDIRECT + controllerName + "?" + queryString;
	}
	
	/**
	 * The Enum MESSAGES.
	 */
	public static enum MESSAGES {

		/** The UIMESSAGE. */
		UIMESSAGE,
		/** The ALERT. */
		ALERT,
		/** The ERROR. */
		ERROR
	}


	private void addAlertMessage(final Model model, final String key) {
		model.addAttribute(AppConstant.HAS_ALERT_MESSAGES_KEY, true);
		model.addAttribute(AppConstant.ALERT_MESSAGE_KEY, key);
	}

	private void addErrorMessage(final Model model, final String key) {
		model.addAttribute(AppConstant.HAS_ERROR_MESSAGES_KEY, true);
		model.addAttribute(AppConstant.ERROR_MESSAGES_KEY, key);
	}

	//TODO: check this 
	private void addErrorMessageFromException(final Throwable e,
			final Model model, final String key) {
		if (key != null) {
			addErrorMessage(model, key);
			return;
		}
		if (e instanceof ServiceException) {
			ServiceException sx = (ServiceException) e;
//			String ekey = sx.getMessageKey();
//			if (ekey == null || StringUtils.isEmpty(key)) {
//				ekey = MessageKeyConstant.SERVICE_DOWN;
			}
			addErrorMessage(model, key);
//		} else {
//			addErrorMessage(model, MessageKeyConstant.SERVICE_DOWN);
//		}

	}

	/**
	 * Adds the message.
	 * 
	 * @param messages
	 *            the messages
	 * @param model
	 *            the model
	 * @param key
	 *            the key
	 */
	protected void addMessage(final MESSAGES messages, final Model model,
			final String key) {
		addMessage(messages, model, key, null);
	}

	/**
	 * Adds the message.
	 * 
	 * @param messages
	 *            the messages
	 * @param model
	 *            the model
	 * @param key
	 *            the key
	 * @param e
	 *            the e
	 */
	private void addMessage(final MESSAGES messages, final Model model,
			final String key, final Throwable e) {
		switch (messages) {
		case UIMESSAGE:
			addUIMessage(model, key);
			break;
		case ALERT:
			addAlertMessage(model, key);
			break;
		case ERROR:
			addErrorMessageFromException(e, model, key);
			break;
		default:
			addUIMessage(model, key);
		}

	}

	/**
	 * Adds the message.
	 * 
	 * @param messages
	 *            the messages
	 * @param model
	 *            the model
	 * @param e
	 *            the e
	 */
	protected void addMessage(final MESSAGES messages, final Model model,
			final Throwable e) {
		addMessage(messages, model, null, e);
	}

	/**
	 * Adds the ui message.
	 * 
	 * @param model
	 *            the model
	 * @param key
	 *            the key
	 */
	private void addUIMessage(final Model model, final String key) {
		model.addAttribute(AppConstant.HASMESSAGES_KEY, true);
		model.addAttribute(AppConstant.MESSAGE_KEY, key);
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
				.append(AppConstant.EXTENSION).append("?").append(queryString)
				.toString();

	}
	
	protected String getInternalRedirectView(final String name) {
		return new StringBuilder().append(AppConstant.REDIRECT).append(name)
				.append(AppConstant.EXTENSION).toString();

	}
}
