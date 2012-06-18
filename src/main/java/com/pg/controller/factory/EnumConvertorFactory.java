package com.pg.controller.factory;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class EnumConvertorFactory implements ConverterFactory<String, Enum>{

	@Override
	public <T extends Enum> Converter<String, T> getConverter(Class<T> arg0) {
		// TODO Auto-generated method stub
		return new EnumConvertor<T>(arg0);
	}
	
	private final class EnumConvertor<T extends Enum> implements Converter<String, T> {

		private Class<T> type;
		
		public EnumConvertor(Class<T> type) {
			this.type = type;
		}
		@SuppressWarnings("unchecked")
		@Override
		public T convert(String value) {
			if(null == value || this.type == null)
				return null;
			return (T)Enum.valueOf(type, value);
		}
	}

}
