package com.own.merchant.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.own.common.constants.ErrorConstants;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantException;
import com.own.transaction.enums.MerchantStatus;
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
	@Column(name = "tableID")
	private Integer id;

	@Column(name = "merchantName")
	@NotEmpty(groups={Pre.class})
	private String name;

	@Column(name = "merchantUserID",unique=true,nullable=false)
	@NotEmpty(groups={Pre.class})
	private String merchantUsername;

	@Transient
	List<MerchantAccount> accounts;

	@Column(name = "merchantEmail",unique=true,nullable=false)
	@Email(groups={Login.class})
	private String emailID;
	
	@Column(name="password")	
	private String password;

	@Column(name="merchantStatus")
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

	private interface Login{
		
	}
	private interface Pre extends Login
	{
		
	}
	private interface Post extends Pre
	{
		
	}
	public enum ValidationType {
		PRE(Pre.class), POST(Post.class),LOGIN(Login.class);
		
		private Class<?> clazz;
		
		private ValidationType(Class<?> clazz) {
			this.clazz = clazz;
		}
		
		public Class<?> getClazz()
		{
			return this.clazz;
		}
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
					errorMap = addToMap(errorMap,ErrorConstants.INVALID_ID, new String[]{"merchant"});
				}
			case PRE:
				if (StringUtils.isEmpty(name)) {
					errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY, new String[]{"merchant name"});
				}
				if (StringUtils.isEmpty(merchantUsername)) {
					errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY,new String[]{"merchant username"});
				}
				if (StringUtils.isEmpty(emailID)) {
					errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY, new String[]{"email-id"});
				}
			

			}

			if (errorMap.size() > 0) {
				throw new IllegalObjectStateException(ExceptionType.VIEW,errorMap, new Throwable());
			}
		}

	}
	public Map<Integer, List<Object>> addToMap(Map<Integer, List<Object>> errorMap,Integer key,Object value) 
	{
		List<Object> list = errorMap.get(key);
		if(null == list)
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

}
;