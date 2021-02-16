package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.entity.Employee;
import com.dilshan.testproj.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	



	// This is a employee table all data saving method
	public void saveData() {


		Employee employee1 = new Employee();
		employee1.setnIC("960654188V");
		employee1.setName("Dilshan");
		employee1.setAge(24);
		employee1.setEmail("dilshantilakaratne29@gmail.com");
		employee1.setContactNumber(773130036);
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setnIC("897654344V");
		employee2.setName("Lasitha");
		employee2.setAge(23);
		employee2.setEmail("lasitha@gmail.com");
		employee2.setContactNumber(714546678);
		employeeRepository.save(employee2);

		Employee employee3 = new Employee();
		employee3.setnIC("786543166V");
		employee3.setName("Thilakarathna");
		employee3.setAge(22);
		employee3.setEmail("thilakarathna@gmail.com");
		employee3.setContactNumber(754543321);
		employeeRepository.save(employee3);

		Employee employee4 = new Employee();
		employee4.setnIC("786543166V");
		employee4.setName("Nimal");
		employee4.setAge(25);
		employee4.setEmail("nimal@gmail.com");
		employee4.setContactNumber(753456789);
		employeeRepository.save(employee4);

	}

	// This is a rest API method of save employee
	public Employee saveEmployee(Employee employee) {

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
}
