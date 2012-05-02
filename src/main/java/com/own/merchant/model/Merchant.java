package com.own.merchant.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantException;
import com.own.transaction.merchant.model.MerchantAccount;

/**
 * This is a class containing the details related to a merchant object TODO -
 * See how JSR303 validations can be applied, Also check on validation Groups
 * 
 * @author ankul
 * 
 */
@Entity
@Table(name = "merchant")
public class Merchant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "merchantID")
	private Integer id;

	@Column(name = "merchantName")
	private String name;

	@Column(name = "merchantUsername")
	private String merchantUsername;

	@Transient
	List<MerchantAccount> accounts;

	@Column(name = "merchantEmail")
	private String emailID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMerchantUsername() {
		return merchantUsername;
	}

	public void setMerchantUsername(String merchantUsername) {
		this.merchantUsername = merchantUsername;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", merchantUsername="
				+ merchantUsername + ", accounts=" + accounts + ", emailID="
				+ emailID + "]";
	}

	/**
	 * Enumerates the types on which the merchant can be searched
	 * 
	 * @author ankul
	 * 
	 */
	public enum SearchTypes {
		EMAIL, ID, NAME
	}

	public enum ValidationType {
		PRE, POST,LOGIN
	}

	/**
	 * This method checks if the merchant is valid or not. A Merchant is checked
	 * for validaity in two cases. Pre-persitance - Merchant is checked if the
	 * mandatory values are present(email,name,details,username/password etc)
	 * Post-persistance - Apart from pre-persistance checks it should have
	 * shared key,unique Merchant ID). Login - Checks if the fields required for
	 * login are present or not Should delegate call to MerchantValidator to get
	 * the desired information
	 * 
	 * @param merchant
	 * @return
	 * @throws MerchantException
	 *             in case the merchant information is nor proper
	 */
	public void validate(ValidationType type)
			throws IllegalObjectStateException {
		{
			Map<String, String> errorMap = new HashMap<String, String>();
			switch (type) {
			case POST:
				if (id <= 0) {
					errorMap.put("invalid.id", "invalid merchant ID");
				}
			case PRE:
				if (StringUtils.isEmpty(name)) {
					errorMap.put("empty.field", "merchant name is empty");
				}
				if (StringUtils.isEmpty(merchantUsername)) {
					errorMap.put("empty.field", "merchant username is empty");
				}
				if (StringUtils.isEmpty(emailID)) {
					errorMap.put("empty.field", "email-id is empty");
				}

			}

			if (errorMap.size() > 0) {
				throw new IllegalObjectStateException(errorMap);
			}
		}

	}

}
;