package com.own.service;

import java.util.Map;

import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.ServiceException;


/**
 * Handles all the methods and process for merchant signUp/registration
 * @author ankul
 *
 */
public interface MerchantRegistrationService {

	
	
	/**
	 * Registers a merchant in the system. Similar to signUp
	 * @param rMerchant
	 * @return
	 */
	public MerchantRegistration registerMerchant(MerchantRegistration rMerchant) throws ServiceException;
	
	
	/**
	 * Checks if a merchant has already registered with us.
	 * @param rMerchant
	 * @return
	 */
	public boolean checkRegistrationByEmail(MerchantRegistration rMerchant);
	
	/**
	 * Get the merchant registration for a email ID if it exists
	 * @param emailID
	 * @return
	 */
	public MerchantRegistration getRegistrationByEmail(String emailID);
	
	/**
	 * Save merchant registration
	 */
	public MerchantRegistration saveRegistration(MerchantRegistration rMerchant);


	/**
	 * Validates a registration object based on the validation type
	 * @param rMerchant
	 * @param signup
	 * @return
	 * @throws ServiceException 
	 */
	public Map<String, String> validate(MerchantRegistration rMerchant,
			ValidationType signup) throws ServiceException;
	
	
}
