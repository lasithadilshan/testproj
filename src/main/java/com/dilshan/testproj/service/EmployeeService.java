package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.entity.Employee;
import com.dilshan.testproj.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	

	// This is a rest API method of save employee
	public Employee saveEmployee(Employee employee) {
		
		LOGGER.info(":: Welcome This is Rest api Employee Saving method :::: EmployeeService - saveEmployee ::");

		return employeeRepository.save(employee);

	}

	
	// This is a employee table data displaying method
	public List<Employee> getEmployeesList() {

		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(Employee -> employeeList.add(Employee));

		for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();

			System.out.println("##################################################################");
			System.out.println("Employee ID             : " + employee.getEmpId());
			System.out.println("Employee NIC            : " + employee.getnIC());
			System.out.println("Employee Name           : " + employee.getName());
			System.out.println("Employee Age            : " + employee.getAge());
			System.out.println("Employee Email          : " + employee.getEmail());
			System.out.println("Employee Contact Number : " + employee.getContactNumber());
			System.out.println("##################################################################");

		}

		return employeeList;
	}
	
	
	
	//This is a employee final salary method
	public Long findCounts(Long empId) {
		
		LOGGER.info(":: Welcome This is Employee Final Salary method :::: EmployeeService - findCounts ::");
		
		Employee employee = employeeRepository.findById(empId).get();
		Long salary = employeeRepository.findCounts(empId) + employee.getSalaryScales().getBasic();
		return salary;
	}
	
}
