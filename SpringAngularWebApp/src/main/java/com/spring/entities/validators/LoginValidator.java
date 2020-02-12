/**
 * 
 */
package com.spring.entities.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.test.login.Login;

/**
 * @author dhiraj
 *
 */
public class LoginValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return LoginValidator.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		String email = login.getEmail();
		String password = login.getPassword();

		if (email.isEmpty() || email == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
					"errors.email.required");
		}
		if (password.isEmpty() || password == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
					"errors.password.required");
		}
	}
}
