package com.dilshan.testproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilshan.testproj.entity.SalaryScale;

@Repository
public interface SalaryScaleRepository extends JpaRepository<SalaryScale,Long>{
	
	

}
