package com.own.service;

import java.util.List;
import java.util.Map;

import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.MerchantRegistration;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

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
	 * Merchant information is validated both at PRE level to check if the
	 * merchant information is consistent
	 * 
	 * @param merchant
	 * @return
	 * @throws DuplicateValueException
	 *             ,MerchantException
	 * @throws ServiceException
	 */
	public Merchant createMerchant(Merchant merchant) throws ServiceException;

	/**
	 * API to update the current state of the merchant to a new state.
	 * 
	 * @param merchant
	 * @return
	 * @throws AppException
	 * @throws ServiceException 
	 */
	public Merchant updateMerchant(Merchant merchant) throws ServiceException;

	/**
	 * Activates the merchant in the system. If merchant is activated, the
	 * merchant account will have to activated seperately
	 * 
	 * @param merchantID
	 * @return
	 * @throws AppException
	 * @throws ServiceException 
	 */
	public Merchant activateMerchant(String merchantID) throws ServiceException;

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
			List<String> accountID, boolean activateAll) throws ServiceException;

	/**
	 * Gets the merchant object based on the params provided. Basically searches
	 * for a merchant to verify if the merchant exists in the system.Returns
	 * single merchant instance or else return null
	 * 
	 * @param merchant
	 * @return Merchant
	 */
	public Merchant getMerchantInfo(Merchant merchant);

	/**
	 * Finds list of merchants based on the search params provided in the map.
	 * 
	 * @param searchParamMap
	 */
	public List<Merchant> findMerchant(Map<SearchTypes, String> searchParamMap);

	/**
	 * Checks if the merchant can login to the system or not.
	 * 
	 * @param merchant
	 * @return
	 * @throws IllegalObjectStateException
	 * @throws ServiceException
	 */
	public Merchant loginUser(Merchant merchant)
			throws IllegalObjectStateException,
			ServiceException;

	/**
	 * Registers a merchant in the system. Similar to signUp
	 * 
	 * @param rMerchant
	 * @return
	 */
	public MerchantRegistration registerMerchant(MerchantRegistration rMerchant);

	/**
	 * On boards a merchant in the system. Entry moves from registration table
	 * to merchant table. Merchant will initially be in a PENDING state. Only
	 * registrations which are in ACTIVE state can be brought onboard
	 * 
	 * @return
	 */
	public Merchant moveMerchantOnBoard(String emailID) throws ServiceException;

	/**
	 * Deactivates a merchant in the system. Merchant is not deleted. All the
	 * merchant accounts associated with the merhcant will also be deactivated
	 * 
	 * @param merchantID
	 * @return
	 */
	public Merchant deActivateMerchant(String merchantID)throws ServiceException;

	/**
	 * Gets the merchant info based on the merchant user ID. Throws an Service exception if the merchant is not found 
	 *  
	 * @param userID
	 * @return
	 */
	public Merchant getMerchantByMerchantUserID(String userID) throws ServiceException;

	/**
	 * Gets the merchant information based on the email ID which is currently the username
	 * @param username
	 * @return
	 * @throws ServiceException 
	 */
	public Merchant getMerchantByUsername(String username) throws ServiceException;

	/**
	 * Checks if the merchant account supplied belongs to the merchant user ID
	 * @param merchantID
	 * @param accountID
	 * @return
	 */
	public MerchantAccount accountBelongsToMerchant(String merchantID, String accountID);

}
