package com.attendance.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.attendance.model.Employee_Details;

public interface UserRepository extends CrudRepository<Employee_Details, Integer> {

	/*
	 * Method created for the login process, this methods checks if a user with the
	 * passed uname and password exists in the database or not. Method is used in
	 * LoginController.
	 */
	public List<Employee_Details> findByUnameAndPassword(String uname, String password);

	/*
	 * This method is created to check whether a user with the same uname already
	 * exists in the table or not. This method is used in RegisterController.
	 */
	public List<Employee_Details> findByUname(String uname);

}
