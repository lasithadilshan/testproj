package com.dilshan.testproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dilshan.testproj.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
