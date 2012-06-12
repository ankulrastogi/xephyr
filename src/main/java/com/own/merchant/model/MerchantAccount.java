package com.own.merchant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "merchantAccount")
public class MerchantAccount implements Serializable {

	public enum MerchantAccountStatus
	{
		PENDING,ACTIVE,INACTIVE
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tableID")
	private long id;
	
	@Id
	@GenericGenerator(name="accIDGen",strategy="com.own.merchant.model.sql.generator.MerchantAccountIDGenerator")
	@GeneratedValue(generator="accIDGen")
	@Column(name = "accountID", unique = true, nullable = false)
	private String accountID;

	@Column(name = "accountName")
	private String name;
	
	@Column(name="merchantUserID")
	private String merchantUserID;
	
	
	@Column(name="accountUniqueKey")
	private String uniqueKey;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private MerchantAccountStatus status;
	

//	@Transient
//	private SubscriptionType subscription;
//
//	@Transient
//	private RenewalPolicy renew;

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public SubscriptionType getSubscription() {
//		return subscription;
//	}
//
//	public void setSubscription(SubscriptionType subscription) {
//		this.subscription = subscription;
//	}
//
//	public RenewalPolicy getRenew() {
//		return renew;
//	}
//
//	public void setRenew(RenewalPolicy renew) {
//		this.renew = renew;
//	}

	public MerchantAccountStatus getStatus() {
		return status;
	}

	public void setStatus(MerchantAccountStatus status) {
		this.status = status;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getMerchantUserID() {
		return merchantUserID;
	}

	public void setMerchantUserID(String merchantUserID) {
		this.merchantUserID = merchantUserID;
	}

	@Override
	public String toString() {
		return "MerchantAccount [id=" + accountID + ", name=" + name
				+ ", merchantUserID=" + merchantUserID + ", uniqueKey="
				+ uniqueKey + ", status=" + status + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
