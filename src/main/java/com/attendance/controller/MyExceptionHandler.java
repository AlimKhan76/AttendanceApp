package com.attendance.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.NoResultException;

/*
 * This handles all the Exceptions that occurs during the execution of the Program
 * and send appropriate message to the view to let the User know what problem has occurred.
 */
@ControllerAdvice
public class MyExceptionHandler {

	/*
	 * This exception is thrown in the LoginController
	 */
	@ExceptionHandler(value = NoResultException.class)
	public String noResult(Model m) {
		m.addAttribute("exception", "No User Found");
		return "index";
	}

	/*
	 * This Exception is thrown in the RegisterController
	 */
	@ExceptionHandler(value = EntityExistsException.class)
	public String UserAlreadyExists(Model m) {
		m.addAttribute("exception", "User Already Exists");
		return "reg-page";
	}

}
