package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.controller.AllowanceController;
import com.dilshan.testproj.entity.Allowance;
import com.dilshan.testproj.repository.AllowanceRepository;

@Service
public class AllowanceService {
	
	@Autowired
	AllowanceRepository allowanceRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AllowanceController.class);
	
	
	// This is a rest API method of save SalaryScale
	public Allowance saveAllowance(Allowance allowance) {
		LOGGER.info(":: Welcome This is Rest api Allowance Saving method :::: AllowanceService - saveAllowance ::");
		return allowanceRepository.save(allowance);

	}
	
	
	public List<Allowance> getAllowanceList() {

		List<Allowance> allowanceList = new ArrayList<>(allowanceRepository.findAll());

		for (Allowance allowance : allowanceList) {

			System.out.println("##################################################################");
			System.out.println("Allowance          : " + allowance.getId());
			System.out.println("Bonus              : " + allowance.getType());
			System.out.println("Travel Expense     : " + allowance.getAmount());
			System.out.println("Employee ID        : " + allowance.getEmployee().getEmpId());
			System.out.println("##################################################################");

		}

		return allowanceList;
	}
	
	
	
	//this is a employee allowance sum method
	public Long findCounts(Long empId) {
		Long allowanceCount = allowanceRepository.findCounts(empId);
		return allowanceCount;
	}

}
