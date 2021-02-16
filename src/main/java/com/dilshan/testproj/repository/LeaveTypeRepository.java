package com.dilshan.testproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilshan.testproj.entity.LeaveType;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long>{
	
	

}
