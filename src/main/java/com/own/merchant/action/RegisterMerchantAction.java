package com.own.merchant.action;

import com.own.merchant.model.Merchant;

/**
 * Comprises of functions that are used for merchant management
 * @author ankul
 *
 */
public class RegisterMerchantAction {

	/**
	 * Registers the provided merchant account. If the merchant is already present,
	 * then the old merchant should be updated with new information.
	 * If the member is an active member then it cannot be updated throw Exception
	 * @param merchant
	 * @return
	 */
	public String registerMerchant(Merchant merchant)
	{
		return null;
	}
	
	public String deRegisterMerchant(Merchant merchant)
	{
		return null;
	}
	
	public String getMerchantStatus(Merchant merchant)
	{
		return null;
	}
	public boolean activateMerchant(Merchant merchant)
	{
		return false;
	}
	
	public boolean deActivateMerchant(Merchant merchant)
	{
		return false;
	}
	
	
	
}
