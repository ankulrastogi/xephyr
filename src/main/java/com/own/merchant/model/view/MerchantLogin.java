package com.own.merchant.model.view;

import org.hibernate.validator.constraints.NotEmpty;

public class MerchantLogin {

	
	@NotEmpty(message="This is not done")
	private String userName;
	
	@NotEmpty
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
