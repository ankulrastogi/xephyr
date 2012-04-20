package com.own.service;

import java.util.List;

import com.own.merchant.model.Merchant;
import com.own.service.exception.AppException;
import com.own.service.exception.DuplicateValueException;

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
	 * 
	 * @param merchant
	 * @return
	 */
	public Merchant createMerchant(Merchant merchant) throws DuplicateValueException;

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
	 * Find the merchant based on the search string
	 * @param params
	 * @return
	 */
	public List<Merchant> searchMerchant(SearchParams params);
	
	
	/**
	 * Finds a merchant by merchantID
	 * @param merchantID
	 * @return
	 */
	public Merchant getMerchantByID(String merchantID);
	
	public Merchant getMerchant(String merchantEmail);
	
	/**
	 * Inner class to incorporate search params needed to search for a merchants
	 * @author ankul
	 *
	 */
	class SearchParams
	{
		
	}
}
