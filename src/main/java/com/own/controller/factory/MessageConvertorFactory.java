package com.own.controller.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.own.controller.utils.ServiceConstants;

@Component
public class MessageConvertorFactory {

	private static Logger logger = Logger.getLogger(MessageConvertorFactory.class);
	
	@Autowired
	MessageSource exceptionMessageSource;

	public Map<String, List<String>> convertExceptionMessages(
			Map<Integer, List<Object>> allErrorMessages) {
		Map<String, List<String>> errorList = new HashMap<String, List<String>>();
		
		for(Integer key:allErrorMessages.keySet())
		{
			List<Object> dataList = allErrorMessages.get(key);
			List<String> decodeList = null;
			decodeList= errorList.get(String.valueOf(key));
			if(null== decodeList)
			decodeList = new ArrayList<String>();
			if(null == dataList || dataList.isEmpty())
			{
				decodeList.add(exceptionMessageSource.getMessage(String.valueOf(key), null,Locale.US));
				errorList.put(String.valueOf(key), decodeList);
				logger.info(errorList);
				return errorList;
			}
			
			for(Object data:dataList)
			{
				 
				
				if(data instanceof String)
				{
					String message = (String)data;
					if(message.trim().length() == 0)
					{
						decodeList.add(exceptionMessageSource.getMessage(String.valueOf(key), null,Locale.US));
					}
					else
					{
						decodeList.add(message);
						
					}
				}
				if(data instanceof Object[])
				{
					decodeList.add(exceptionMessageSource.getMessage(String.valueOf(key), (Object[])data,Locale.US));
				}
			}
			
			errorList.put(String.valueOf(key), decodeList);
		}
		logger.info(errorList);
		return errorList;
	}

	public Collection<? extends String> convertToList(
			Map<String, List<String>> convertExceptionMessages) {
		List<String> resultList = new ArrayList<String>();
		for(String key:convertExceptionMessages.keySet())
		{
			resultList.addAll(convertExceptionMessages.get(key));
		}
		return resultList;
	}

	public Map<String, List<String>> getMessage(Integer messageCode)
	{
		Map<String, List<String>> successList = new HashMap<String, List<String>>();
		
		List<String> resultList = new ArrayList<String>();
		resultList.add(exceptionMessageSource.getMessage(String.valueOf(messageCode), null,Locale.US));
		successList.put(String.valueOf(messageCode), resultList);
		return successList;
	}
	
	public Map<String, List<String>> getMessage(Integer messageCode,Object[] placeHolders)
	{
		Map<String, List<String>> successList = new HashMap<String, List<String>>();
		
		List<String> resultList = new ArrayList<String>();
		resultList.add(exceptionMessageSource.getMessage(String.valueOf(messageCode), placeHolders,Locale.US));
		successList.put(String.valueOf(messageCode), resultList);
		return successList;
	}
	
	public Map<String, List<String>> getSuccessMessage(
			Integer messageCode) {
		Map<String, List<String>> successList = new HashMap<String, List<String>>();
		
		List<String> resultList = new ArrayList<String>();
		resultList.add(exceptionMessageSource.getMessage(String.valueOf(messageCode), null,Locale.US));
		successList.put(ServiceConstants.SUCCESS_MESSAGE_CODE, resultList);
		return successList;
	}
	
	
}
