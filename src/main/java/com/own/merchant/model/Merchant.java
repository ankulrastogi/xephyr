package com.own.merchant.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.own.transaction.merchant.model.MerchantAccount;

/**
 * This is a class containing the details related to a merchant object
 * @author ankul
 *
 */
@Entity
@Table(name="merchant")
public class Merchant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="merchantID",unique=true,nullable=false,insertable=false)
	private Integer id;
	
	@Column(name="merchantName")
	private String name;
	
	@Column(name="merchantUsername")
	private String merchantUsername;

	@Transient
	List<MerchantAccount> accounts;
	
	

	@Column(name="merchantEmail")
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

	/**
	 * Enumerates the types on which the merchant can be searched
	 * @author ankul
	 *
	 */
	public enum SearchTypes
	{
		EMAIL,ID,NAME
	}
	
}
