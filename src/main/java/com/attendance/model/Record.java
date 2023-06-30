package com.attendance.model;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/*
 * This Table keeps the record of all the login and logout date and time
 * of all the user with respect to their username.
 */
@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// Stores the username of the user which has logged in or logged out
	private String uname;

	/*
	 * Stores the Date of login or logout to the database
	 * 
	 * @CreationTimeStamp sets the timestamp to the current time at the time of
	 * saving the entity.
	 * 
	 * @Temporal saves the Timestamp in the form of date to the database
	 */
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date logdate = new Date();

	/*
	 * Stores the Time of login or logout to the database
	 * 
	 * @CreationTimeStamp sets the timestamp to the current time at the time of
	 * saving the entity.
	 * 
	 * @Temporal saves the Timestamp in the form of time to the database
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	private Date logtime = new Date();

	// Shows whether the user logged in or logged out
	private String status;

	// Getter and Setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getLogdate() {
		return logdate;
	}

	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

	// Constructors
	public Record(int id, String uname, Date logdate, Date logtime, String status) {
		super();
		this.id = id;
		this.uname = uname;
		this.logdate = logdate;
		this.logtime = logtime;
		this.status = status;
	}

	public Record() {
		super();
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", uname=" + uname + ", logdate=" + logdate + ", logtime=" + logtime + ", status="
				+ status + "]";
	}

}
