/**
 * 
 */
package com.spring.test.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.LoginValidatorDao;
import com.spring.dao.PasswordMismatchException;
import com.spring.entities.validators.LoginValidator;
import com.spring.test.exceptions.EmailDoesNotExistsException;
import com.spring.test.exceptions.UserAlreadyExistsException;
import com.spring.test.login.Login;

/**
 * @author dhiraj
 *
 */

@Controller
public class LoginController {

	@Autowired
	protected LoginValidator loginValidator;

	@Autowired
	protected LoginValidatorDao loginValidatorDao;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Login login = new Login();
		modelAndView.addObject(login);
		modelAndView.setViewName("login");
		request.setAttribute("login", login);
		return modelAndView;
	}

	@RequestMapping(value = "/loginSubmit")
	public String loginSubmit(@ModelAttribute("login") Login login,
			HttpServletRequest request, BindingResult errors) throws EmailDoesNotExistsException, PasswordMismatchException {

		loginValidator.validate(login, errors);
		if (errors.hasErrors()) {
			return "login";
		}
		request.setAttribute("login", login);
		if(loginValidatorDao.validateUser(login)){
			return "successHome";
		}
		return "login";
	}
}
