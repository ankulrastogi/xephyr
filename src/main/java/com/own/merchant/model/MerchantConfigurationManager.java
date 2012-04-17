package com.own.merchant.model;

import java.util.List;
import java.util.Map;

/**
 * Loads and manages the configuration related information for the merchants, Each merchant
 * will have its own configurations which dictates the flow of the transactions origionating from
 * the merchant source. These will be applied to each merchant account
 * @author ankul
 *
 */
public class MerchantConfigurationManager {

	private String configFile;
	
	private Map<String, Object> configurations;
	
	public MerchantConfigurationManager(String filePath)
	{
		this.configFile = filePath;
	}
	
	public MerchantConfigurationManager(Merchant merchant)
	{
		this.configFile = null;//merchant.getConfiguration();
	}
	
	public void loadConfigurationForMerchant()
	{
		
	}
	
	public Object getConfiguration(String value)
	{
		return null;
	}
	/**
	 * Returns the map of the requested configurations 
	 * @param value
	 * @return
	 */
	public Map<String, Object> getConfigurations(String ...value)
	{
		return null;
	}
	
	public boolean putConfiguration(String value,Object data)
	{
		return false;
	}
	
	public boolean putConfigurations(Map<String, Object> values)
	{
		return false;
	}
	
	public boolean saveConfigurations()
	{
		return false;
	}
	
}
