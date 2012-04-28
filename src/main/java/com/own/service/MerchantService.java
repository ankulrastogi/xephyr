package com.own.service;

import java.util.List;
import java.util.Map;

import com.own.merchant.manager.MerchantValidatorImpl.ValidationType;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.service.exception.AppException;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.MerchantException;
import com.own.service.exception.MerchantValidationException;

/**
 * Base service for merchant. All the operations defined for a merchant will be
 * defined in this service
 * 
 * @author ankul
 * 
 */

public interface MerchantService {

	/**
	 * Creates a merchant in a system. If the merchant already exists then an
	 * error is thrown, along with the already existing merchant information.
	 * Merchant information is validated both at PRE level to check if the merchant information is consistent
	 * 
	 * @param merchant
	 * @param type TODO
	 * @return
	 * @throws DuplicateValueException,MerchantException 
	 */
	public Merchant createMerchant(Merchant merchant, ValidationType type) throws DuplicateValueException, DuplicateValueException,MerchantException;

	/**
	 * API to update the current state of the merchant to a new state.
	 * 
	 * @param merchant
	 * @return
	 * @throws AppException
	 */
	public Merchant updateMerchant(Merchant merchant) throws AppException;

	/**
	 * API to delete the merchant. Merchant will never be deleted, only his
	 * status will be moved to ACTIVE to INACTIVE. If a merchant is INACTIVE,
	 * all the associated merchant Account will be marked INACTIVE.The method
	 * will return the Merchant object with modified values.
	 * 
	 * @throws AppException
	 */
	public Merchant deActivateMerchant(Merchant merchant) throws AppException;

	/**
	 * Activates the merchant in the system. If merchant is activated, the
	 * merchant account will have to activated seperately
	 * 
	 * @param merchant
	 * @return
	 * @throws AppException
	 */
	public Merchant activateMerchant(Merchant merchant) throws AppException;

	/**
	 * Process to activate all or selective merchant accounts for a merchant
	 * 
	 * @param merchant
	 * @param accountID
	 * @param activateAll
	 * @return
	 * @throws AppException
	 */
	public Merchant activateMerchantAccount(Merchant merchant,
			List<String> accountID, boolean activateAll) throws AppException;

	/**
	 * Gets the merchant object based on the params provided.
	 * Basically searches for a merchant to verify if the merchant exists in the
	 * system.Returns single merchant instance or else return null
	 * @param merchant
	 * @return Merchant
	 */
	public Merchant getMerchantInfo(Merchant merchant);
	
	
	//public List<Merchant> getMerchantInfo()
	
	/**
	 * Finds a merchant by merchantID
	 * @param merchantID
	 * @return
	 */
	public Merchant getMerchantByID(String merchantID);
	
	/**
	 * Finds a merchant by merchant Email. There will be only one merchant account associcated with an email
	 * @param merchantEmail
	 * @return
	 */
	public Merchant getMerchantByEmail(String merchantEmail);
	
	
	/**
	 * Finds list of merchants based on the search params provided in the map.
	 * @param searchParamMap
	 */
	public List<Merchant> findMerchant(Map<SearchTypes, String> searchParamMap);

	/**
	 * Checks if the merchant can login to the system or not.
	 * @param merchant
	 * @return
	 */
	public boolean authenticate(Merchant merchant) throws MerchantValidationException;
	
	

}
