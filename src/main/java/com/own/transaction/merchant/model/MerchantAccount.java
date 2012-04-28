package com.own.transaction.merchant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.own.merchant.enums.SubscriptionType;
import com.own.transaction.policy.RenewalPolicy;

@Entity
@Table(name = "merchantAccount")
public class MerchantAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "accountName")
	private String name;

	@Transient
	
	private SubscriptionType subscription;

	@Transient
	private RenewalPolicy renew;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubscriptionType getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionType subscription) {
		this.subscription = subscription;
	}

	public RenewalPolicy getRenew() {
		return renew;
	}

	public void setRenew(RenewalPolicy renew) {
		this.renew = renew;
	}
	
	private Integer version;
	@Version
	@Column(name="OPTLOCK")
	public Integer getVersion()
	{
		return version;
	}
	
	public void setVersion(Integer version)
	{
		this.version = version;
	}

}
