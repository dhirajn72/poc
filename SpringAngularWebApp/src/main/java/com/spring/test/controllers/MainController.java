/**
 * 
 */
package com.spring.test.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.RegisterDao;
import com.spring.entities.validators.RegisterValidator;
import com.spring.test.exceptions.UserAlreadyExistsException;
import com.spring.test.to.RegisterTo;

/**
 * @author dhiraj
 *
 */
@Controller
public class MainController {

	@Autowired
	protected RegisterValidator registerValidator;

	@Autowired
	protected RegisterDao registerDao;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterTo registerTo = new RegisterTo();
		modelAndView.addObject(registerTo);
		modelAndView.setViewName("register");
		request.setAttribute("registerTo", registerTo);

		return modelAndView;
	}

	@RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
	public String registerSubmit(@ModelAttribute("registerTo") RegisterTo registerTo,
			HttpServletRequest request, BindingResult errors)throws UserAlreadyExistsException {

		registerValidator.validate(registerTo, errors);
		if (errors.hasErrors()) {
			return "register";
		}
		request.setAttribute("registerTo", registerTo);
		registerDao.registerUser(registerTo);
		return "succcess";
	}
}
