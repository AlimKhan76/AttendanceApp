package com.attendance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.attendance.dao.UserRepository;
import com.attendance.model.Employee_Details;
import jakarta.persistence.EntityExistsException;

/*Controller is used only for redirecting to register page and 
 * registering the user to the database after checks*/
@Controller
public class RegisterController {

	// Repository used for Database operation with the entity User
	@Autowired
	private UserRepository userRepository;

	// Redirects to the User Registration Page
	@RequestMapping("reg-page")
	public String home() {
		return "reg-page";
	}

	// Registers the user to the Database after checks using UserRepositorys
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public RedirectView NewRegisteration(RedirectAttributes redi, @ModelAttribute Employee_Details emp,
			@RequestParam String uname) {
		// Finding the user in the database using uname variable
		List<Employee_Details> list = userRepository.findByUname(uname);

		// Checks if such a user exists in the database
		if (list.isEmpty()) {
			// If no such user exists then the data is saved to the database
			userRepository.save(emp);

			// Sends the success message to view i.e. the login page
			String msg = emp.getUname() + " registered successfully";
			redi.addFlashAttribute("success", msg);

			// Setting redirectUrl to solve the problem of form resubmission
			RedirectView redirect = new RedirectView();
			redirect.setUrl("login");
			return redirect;
		}

		/*
		 * If the user with the same Uname exists in the database then
		 * EntityExistsException is thrown and MyExceptionHandler handles the exception
		 * and sends the appropriate message to the view
		 */
		else {
			throw new EntityExistsException();
		}
	}
}
