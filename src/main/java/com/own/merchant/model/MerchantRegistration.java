package com.own.merchant.model;

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

import com.own.common.constants.ErrorConstants;
import com.own.service.exception.BaseException.ExceptionType;
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
	
	@Column(name="merchantEmail",unique=true,nullable=false)
	private String email;
	
	@Column(name="merchantPassword")
	private String password;
	
	@Column(name="activationURLstring",unique=true,nullable=false)
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
		Map<Integer, List<Object>> errorMap = new HashMap<Integer, List<Object>>();
		
		switch(type)
		{
		case POST://conditions for POST
					if(this.signUpID == 0)
						errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY, new String[]{"SignUp ID"});
		case PRE: //conditions for pre persistence
					if(this.status == null)
						errorMap = addToMap(errorMap, ErrorConstants.FIELD_EMPTY, new String[]{"status "});
		case SIGNUP://conditions for signup
					if(StringUtils.isEmpty(this.activationLink))
						errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY,new String[]{"activation link "});
					if(StringUtils.isEmpty(this.email))
						errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY,new String[]{"email"});
					if(StringUtils.isEmpty(this.password))
						errorMap = addToMap(errorMap,ErrorConstants.FIELD_EMPTY, new String[]{"password"});
		}
		
		if(!errorMap.isEmpty())
			throw new IllegalObjectStateException(ExceptionType.VIEW,errorMap, new Throwable());
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
