package com.own.merchant.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.own.merchant.model.Merchant;

/**
 * Class to perform merchant validations based on the type of validations passed
 * 
 * @author ankul
 * 
 */
@Component
public class MerchantValidatorImpl implements MerchantValidator {
	public enum ValidationType {
		PRE, POST, LOGIN
	}

	private ValidationType DEFAULT = ValidationType.PRE;
	private ValidationType type;

	public MerchantValidatorImpl() {
		this.type = DEFAULT;
	}
	
	Map<String, String> errorMap = new HashMap<String, String>();

	private  void validate(Merchant merchant) {

		switch (type) {

		case POST:// validations related to POST-persistance

		case PRE: // validations related to PRE-persistance
			break;
		case LOGIN: // basic username password validations
			break;
		default:
			break;
		}

	}

	@Override
	public void setValidationType(ValidationType type) {

		this.type = type;

	}

	@Override
	public boolean isValidMerchant(Merchant merchant, ValidationType type) {

		this.type = type;

		return isValidMerchant(merchant);
	}

	
	private boolean isValidMerchant(Merchant merchant) {

		validate(merchant);
		if (errorMap.size() == 0)
			return true;
		return false;
	}

	
	private Map<String, String> validateMerchant(Merchant merchant) {

		validate(merchant);
		return errorMap;
	}
	

	@Override
	public Map<String, String> validateMerchant(Merchant merchant,
			ValidationType type) {
		this.type = type;

		return validateMerchant(merchant);

	}

}
