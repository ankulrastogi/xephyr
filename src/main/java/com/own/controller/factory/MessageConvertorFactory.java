package com.own.controller.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

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
	
	
}
