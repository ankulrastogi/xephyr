package com.own.merchant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="merchantSignUp")
public class MerchantRegistration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="signUpID")
	private Integer signUpID;
	
	@Column(name="merchantName")
	private String name;
	
	@Column(name="merchantEmail")
	private String email;
	
	@Column(name="merchantPassword")
	private String password;
	
	@Column(name="activationURLstring")
	private String activationLink;
	
	@Column(name="registrationStatus")
	private String status;

	public Integer getSignUpID() {
		return signUpID;
	}

	public void setSignUpID(Integer signUpID) {
		this.signUpID = signUpID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationLink() {
		return activationLink;
	}

	public void setActivationLink(String activationLink) {
		this.activationLink = activationLink;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MerchantRegistration [signUpID=" + signUpID + ", name=" + name
				+ ", email=" + email + ", password=" + password
				+ ", activationLink=" + activationLink + ", status=" + status
				+ "]";
	}
	
	
}
