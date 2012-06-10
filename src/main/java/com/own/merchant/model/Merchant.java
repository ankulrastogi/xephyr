package com.own.merchant.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.own.common.constants.ErrorConstants;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantException;
import com.own.transaction.enums.MerchantStatus;

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

	@Column(name = "tableID")
	private Integer id;

	@Column(name = "merchantName")
	private String name;

	 @Id
	 @GenericGenerator(name="uuid-gen",strategy="uuid")
	 @GeneratedValue(generator="uuid-gen")
	// @GenericGenerator(name="userIDGen",strategy="com.own.merchant.model.sql.generator.MerchantUserIDGenerator")
	// @GeneratedValue(generator="userIDGen")
	@Column(name = "merchantUserID", unique = true, nullable = false)
	private String merchantUserID;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="merchantUserID")
	private List<MerchantAccount> accounts;

	@Column(name = "merchantEmail", unique = true, nullable = false)
	private String emailID;

	@Column(name = "password")
	private String password;

	@Column(name = "merchantStatus")
	@Enumerated(EnumType.STRING)
	private MerchantStatus status;

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

	public String getMerchantUserID() {
		return merchantUserID;
	}

	public void setMerchantUserID(String merchantUserID) {
		this.merchantUserID = merchantUserID;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", merchantUsername="
				+ merchantUserID + ", accounts=" + getAccounts() + ", emailID="
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
		PRE, POST, LOGIN;
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
			Map<Integer, List<Object>> errorMap = new HashMap<Integer, List<Object>>();
			switch (type) {
			case POST:
				if (id <= 0) {
					errorMap = addToMap(errorMap, ErrorConstants.INVALID_ID,
							new String[] { "merchant" });
				}
			case PRE:
				if (StringUtils.isEmpty(name)) {
					errorMap = addToMap(errorMap, ErrorConstants.FIELD_EMPTY,
							new String[] { "merchant name" });
				}

			case LOGIN:

				if (StringUtils.isEmpty(emailID)) {
					errorMap = addToMap(errorMap, ErrorConstants.FIELD_EMPTY,
							new String[] { "username" });
				}
				if (StringUtils.isEmpty(password)) {
					errorMap = addToMap(errorMap, ErrorConstants.FIELD_EMPTY,
							new String[] { "password" });
				}

			}

			if (errorMap.size() > 0) {
				throw new IllegalObjectStateException(ExceptionType.VIEW,
						errorMap, new Throwable());
			}
		}

	}

	public Map<Integer, List<Object>> addToMap(
			Map<Integer, List<Object>> errorMap, Integer key, Object value) {
		List<Object> list = errorMap.get(key);
		if (null == list)
			list = new ArrayList<Object>();
		list.add(value);
		errorMap.put(key, list);
		return errorMap;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MerchantStatus getStatus() {
		return status;
	}

	public void setStatus(MerchantStatus status) {
		this.status = status;
	}

	public List<MerchantAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<MerchantAccount> accounts) {
		this.accounts = accounts;
	}

};
