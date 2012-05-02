package com.own.merchant.model;

import java.util.HashMap;
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
	private RegistrationStatus status;
	
	@Transient
	private String rePassword;

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

	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MerchantRegistration [signUpID=" + signUpID + ", name=" + name
				+ ", email=" + email + ", password=" + password
				+ ", activationLink=" + activationLink + ", status=" + status
				+ "]";
	}
	

	public enum ValidationType
	{
		SIGNUP,PRE,POST
	}
	
	public enum RegistrationStatus
	{
		PENDING, ACTIVE
	}
	public void validate(ValidationType type) throws IllegalObjectStateException
	{
		Map<String, String> errorMap = new HashMap<String, String>();
		
		switch(type)
		{
		case POST://conditions for POST
					if(this.signUpID == 0)
						errorMap.put("field.empty", "SignUp ID is empty");
		case PRE: //conditions for pre persistence
					if(this.status == null)
						errorMap.put("field.empty", "status is empty");
		case SIGNUP://conditions for signup
					if(StringUtils.isEmpty(this.activationLink))
						errorMap.put("field.empty", "activation link is empty");
					if(StringUtils.isEmpty(this.email))
						errorMap.put("field.empty", "email link is empty");
					if(StringUtils.isEmpty(this.password))
						errorMap.put("field.empty", "password is empty");
		}
		
		if(!errorMap.isEmpty())
			throw new IllegalObjectStateException(errorMap);
	}
	
	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	{
		
	}
	
	public boolean activationExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean consumed() {
		// TODO Auto-generated method stub
		return this.getStatus().equals(RegistrationStatus.ACTIVE);
	}
}
