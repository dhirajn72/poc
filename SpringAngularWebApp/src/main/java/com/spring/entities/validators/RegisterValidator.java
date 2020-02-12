/**
 * 
 */
package com.spring.entities.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.entities.Register;
import com.spring.test.to.RegisterTo;

/**
 * @author dhiraj
 *
 */
public class RegisterValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return RegisterValidator.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		RegisterTo register = (RegisterTo) target;
		String name = register.getName();
		String email = register.getEmail();
		String password = register.getPassword();
		String confirmPassword = register.getConfirmPassword();

		if (name.isEmpty() || name == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "errors.name.required");
		}
		if (email.isEmpty() || email == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "errors.email.required");
		}
		if (password.isEmpty() || password == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "errors.password.required");
		}
		if (confirmPassword.isEmpty() || confirmPassword == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPassword", "errors.confPass.required");
		}
	}
}
