package com.own.merchant.model.view.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.Errors;

import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.view.form.annotations.MatchValues;
import com.own.merchant.model.view.form.annotations.ValidEmail;

@MatchValues.List(
{
	@MatchValues(field="email",verifyField="verifyEmail",message="{email.verify.mismatch}"),
	@MatchValues(field="password",verifyField="verifyPassword",message="{password.verify.mismatch}")
})
public class NewRegistrationFormModel {

	@ValidEmail
	private String email;
	
	@ValidEmail
	private String verifyEmail;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String verifyPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	
	static class NewRegistrationFormModelValidator
	{
		public static Errors validate(NewRegistrationFormModel model,Errors errors)
		{
			//Validate if the email and verify email match
			
			return errors;
		}
	}

	public MerchantRegistration convertToRegistration() {
		MerchantRegistration register = new MerchantRegistration();
		register.setFirstName(this.firstName);
		register.setLastName(this.lastName);
		register.setPassword(this.password);
		register.setEmail(this.email);
		return register;
	}
	
}
