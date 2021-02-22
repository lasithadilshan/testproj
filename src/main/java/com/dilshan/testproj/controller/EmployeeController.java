package com.dilshan.testproj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.testproj.entity.Employee;
import com.dilshan.testproj.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/")
	public Employee saveEmployee(@RequestBody Employee employee) {

		LOGGER.info(":: Welcome This is Rest api Employee Saving :::: EmployeeController - saveEmployee ::");
		return employeeService.saveEmployee(employee);

	}
	
	@GetMapping("/")
	public List<Employee> readEmployee() {
		LOGGER.info(":: read employee :::: EmployeeController - readEmployee ::");
		return employeeService.getEmployeesList();
	}
	
	
	@PostMapping("/requestSalary")
	public Long requestSalary(@RequestParam("empId") Long empId) {

		LOGGER.info(":: Welcome This is Rest api Request Salary :::: EmployeeController - requestSalary ::");
		return employeeService.findCounts(empId);

	}

}
