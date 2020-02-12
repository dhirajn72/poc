/**
 * 
 */
package com.spring.test.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.PasswordMismatchException;

/**
 * @author dhiraj
 *
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ModelAndView handleUserAlreadyExistsException(
			UserAlreadyExistsException ex) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("errRegMessage", ex.getMessage());
		return model;
	}

	@ExceptionHandler(EmailDoesNotExistsException.class)
	public ModelAndView handleEmailDoesNotExistsException(
			EmailDoesNotExistsException ex) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("errLoginMessage", ex.getMessage());
		return model;
	}

	@ExceptionHandler(PasswordMismatchException.class)
	public ModelAndView handleEmailAlreadyExistsException(
			PasswordMismatchException ex) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("errPassMissmatch", ex.getMessage());
		return model;
	}

}