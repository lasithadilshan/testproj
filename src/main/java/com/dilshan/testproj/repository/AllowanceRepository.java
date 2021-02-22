package com.dilshan.testproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dilshan.testproj.entity.Allowance;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance,Long>{
	
	@Query(value = "SELECT sum(amount) FROM allowance WHERE employee_emp_id = ?1",nativeQuery = true)
	Long findCounts(Long employee_emp_id);

}