package com.rest.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rest.test.to.StudentTo;
import com.rest.test.to.Students;

/**
 * 
 * This is a spring integration with rest webservices
 * 
 * @author dhiraj
 *
 */
@Controller
public class StudentController {

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public String getStudent(@PathVariable int id, ModelMap model) {
		System.out.println("in getStudent()");
		StudentTo st = new StudentTo(id, "sri", "sri@jlc.com", 99999);
		model.addAttribute("STUD", st);
		return "index";
	}

	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add/{name}/{email}/{phone}", method = RequestMethod.POST, produces = { "application/text" })
	public @ResponseBody String addStudent(@PathVariable String name,
			@PathVariable String email, @PathVariable long phone, ModelMap model) {
		System.out.println("in addStudent()");
		StudentTo to = new StudentTo(222, name, email, Integer.valueOf(phone
				+ ""));
		System.out.println("in server:" + to);
		model.addAttribute("ADDED", "Student info added successfulyy");
		return "Your details stored in database";
	}

	/**
	 * Two scenarios has been covered here to set HTTP response code
	 *  1) @ResponseStatus(value = HttpStatus.FORBIDDEN)
	 *  2) Pass an extra parameter in the method of type HttpServletResponse and explicitly 
	 *  set the code 
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = { "application/json" })
	//@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public @ResponseBody List getAllStudent(ModelMap model,
			HttpServletResponse response) {
		System.out.println("in getAllStudent()");

		List<StudentTo> tos = new ArrayList<StudentTo>();
		tos.add(new StudentTo(1, "mk", "mk@gmail.com", 99999));
		tos.add(new StudentTo(2, "dk", "dk@gmail.com", 5555));
		tos.add(new StudentTo(3, "mk", "sk@gmail.com", 7777));
		tos.add(new StudentTo(4, "sk", "sk@gmail.com", 8888));
		tos.add(new StudentTo(5, "ck", "ck@gmail.com", 887777));

		Students list = new Students();
		list.setStudentTos(tos);
		model.addAttribute("LIST", list);
		System.out.println(response);
		
		//response.setStatus(404);
		return tos;
	}
}
