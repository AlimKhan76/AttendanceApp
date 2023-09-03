package com.attendance.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.attendance.model.Employee_Details;
import com.attendance.model.Record;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

import com.attendance.dao.RecordRepository;
import com.attendance.dao.UserRepository;

/*
 * Controller used for logging in and registering the login and logout date & time
 * to the database
 */
@Controller
public class LoginController {

	// Used to save log data to the record table in the database
	@Autowired
	private RecordRepository recordRepository;

	// Used for logging in as admin and as a common user
	@Autowired
	private UserRepository userRepository;

	// Redirect to the page where the user login
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	// Used for the button in the Register page to redirect to the login page
	@RequestMapping("login")
	public String LoginPage() {
		return "Login-form";
	}
	
	//Used for redirecting to logout page
	@RequestMapping("logOutRedirect")
	public String LogOutForm() {
		return "Logout-form";
	}

	/*
	 * Used for the logging and setting the login details to the record table
	 */
	@RequestMapping(value = "log", method = RequestMethod.POST)
	public String validate(Model m, @ModelAttribute Record record, @RequestParam String uname,
			@RequestParam String password) {

		/*
		 * Checks if the user is admin or not If the user is a admin it will then
		 * redirect to a page containing details of all the Employee and the admin can
		 * now view all the log details by selecting a particular Employee
		 */
		if (uname.equals("admin") && password.equals("admin")) {
			System.out.println("Admin logging in");
			// Find all the users and send them to the view for the admin to view
			Iterable<Employee_Details> list = userRepository.findAll();
			m.addAttribute("allUser", list);
			return "admin-view";
		}
		/*
		 * If the user is not an admin then the uname and password are checked in the
		 * database, to see if they exists or not.
		 */
		else {
			List<Employee_Details> list = userRepository.findByUnameAndPassword(uname, password);
			/*
			 * If the list is empty means there is no user with the uname and password
			 * provided and a NoResultException is thrown and handled by the
			 * MyExceptionHandler Class
			 */

			if (list.isEmpty()) {
				// throws Exception
				throw new NoResultException();
			} else {
				/*
				 * If such a user with the given uname and password does exists in the database
				 * then the login date and time and status is saved to the record table using
				 * RecordRepository
				 */
				// Explicitly setting the login status
				record.setStatus("Logged IN");

				// Saving the data to the database
				recordRepository.save(record);
				System.out.println("Logged in successfully");
				Date date = record.getLogdate();
				System.out.println(record);

				/*
				 * Sending the login date, time, status, name to the view through Model for the
				 * user to view his current login date and time and status along with the name.
				 */
				m.addAttribute("Date", date);
				m.addAttribute("status", "Logged IN");
				m.addAttribute("Name", record.getUname());
				return "Login-page";
			}
		}
	}

	/*
	 * Handles the logout logic of the project
	 */
	@RequestMapping(value="logOut", method = RequestMethod.POST)
	public String logOut(@ModelAttribute Record record, Model m, @RequestParam String uname,
							@RequestParam String password) {
		
		List<Employee_Details> list = userRepository.findByUnameAndPassword(uname, password);
		/**
		 * If the list is empty means there is no user with the uname and password
		 * provided and a NoResultException is thrown and handled by the
		 * MyExceptionHandler Class
		 **/

		if (list.isEmpty()) {
			// throws Exception
			throw new NonUniqueResultException();
		} else {

		
		// Explicitly setting the status to logged out
		record.setStatus("Logged Out");
		// Explicitly setting the uname received through the hidden input field in
		// login-page
		record.setUname(uname);
		// Saving the data to the database
		recordRepository.save(record);
		System.out.println("Logged out successfully");
		Date date = record.getLogdate();
		System.out.println(record);
		/*
		 * Sending the logout date, time, status, name to the view through Model for the
		 * user to view his current logout date and time and status along with the name.
		 */
		m.addAttribute("Date", date);
		m.addAttribute("status", "Logged Out");
		m.addAttribute("Name", uname);
		return "LogOut-page";
	}
	}

	/*
	 * This controller is used to view the Attendance Report of a specific user It
	 * can be used by the user logged in to view his Attendance Or by the admin to
	 * view the Attendance of any specific employee.
	 */
	@RequestMapping(value = "report/{name}/{page}", method = RequestMethod.GET)
	public String ReportofUser(@PathVariable int page, @PathVariable String name, Model m) {
		// Finding all the record in the name of the user provided
		Pageable pageable=PageRequest.of(page,12);
		Page<Record> datalist = recordRepository.findByUnameOrderByLogdateDesc(name, pageable);
		List<Record> list=datalist.getContent();
		// Sending the record to the view through Model
		m.addAttribute("list", list);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", datalist.getTotalPages());
		
		m.addAttribute("Name", name);
		return "Attendance-Report";
	}

}
