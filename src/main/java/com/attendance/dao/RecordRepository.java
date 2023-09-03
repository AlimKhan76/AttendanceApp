package com.attendance.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.attendance.model.Record;

public interface RecordRepository extends CrudRepository<Record, Integer> {

	/*
	 * Methods created to find the record of login and logout date and time from the
	 * record table by using uname as a parameter to find the appropriate data. Only
	 * data of the uname passed as the parameter will be returned from the record
	 * table This method is used in the LoginController
	 */
	public Page<Record> findByUnameOrderByLogdateDesc(String uname,Pageable pageable);
	
	public List<Record> findByUnameOrderByLogdateDesc(String uname);

}
