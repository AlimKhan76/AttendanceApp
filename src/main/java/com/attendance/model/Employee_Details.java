package com.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Stores the data of the employee which will be used for login later on
 */
@Entity
public class Employee_Details {

	// Uname is used for login action so it has to be Unique and hence given the @Id
	// attribute
	@Id
	private String uname;
	private String password;
	private String email;
	private String phone_number;

	// Getters and Setters
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	// Constructors
	public Employee_Details(String uname, String password, String email, String phone_number) {
		super();

		this.uname = uname;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
	}

	public Employee_Details() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [uname=" + uname + ", password=" + password + ", email=" + email + ", phone_number="
				+ phone_number + "]";
	}
}
