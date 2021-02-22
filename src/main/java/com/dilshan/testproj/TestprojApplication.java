package com.dilshan.testproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dilshan.testproj.service.LeaveSummeryService;
import com.dilshan.testproj.service.EmployeeService;
import com.dilshan.testproj.service.LeaveTypeService;

@SpringBootApplication
public class TestprojApplication implements CommandLineRunner{
	
	@Autowired
	LeaveTypeService leaveTypeService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LeaveSummeryService leaveSummeryService;

	public static void main(String[] args) {
		SpringApplication.run(TestprojApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		leaveTypeService.saveData();
//		leaveTypeService.getleaveTypesList();
//		employeeService.saveData();
//		employeeService.getEmployeesList();
//		
//		leaveService.getAccountList();	
		
//		accountService.findCounts(7L, 4L);
//		accountService.requestLeave(7L, 4L,1);
		
	}

}
