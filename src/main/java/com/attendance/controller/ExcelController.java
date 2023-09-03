package com.attendance.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.attendance.dao.RecordRepository;
import com.attendance.excel.ExcelGenerator;
import com.attendance.model.Record;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ExcelController {
	@Autowired
	private RecordRepository recordRepository;


	
	@GetMapping("export-to-excel/{uname}")
    public void exportIntoExcelFile(HttpServletResponse response, @PathVariable String uname) throws IOException {
       System.out.println(uname);
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Attendance-Report-of-"+uname +" "+ currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Record> listOfStudents = recordRepository.findByUnameOrderByLogdateDesc(uname);
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        generator.generateExcelFile(response);
    }

}
