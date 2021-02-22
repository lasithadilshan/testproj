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

import com.dilshan.testproj.entity.Allowance;
import com.dilshan.testproj.service.AllowanceService;

@RestController
@RequestMapping("/allowance")
public class AllowanceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AllowanceController.class);
	
	@Autowired
	AllowanceService allowanceService;

	@PostMapping("/")
	public Allowance saveAllowance(@RequestBody Allowance allowance) {

		LOGGER.info(":: Welcome This is Rest api Allowance Saving :::: AllowanceController - saveAllowance ::");
		return allowanceService.saveAllowance(allowance);

	}
	
	@GetMapping("/")
	public List<Allowance> readAllowance() {
		LOGGER.info(":: read salaryScale :::: AllowanceController - readAllowance ::");
		return allowanceService.getAllowanceList();
	}
	
	@PostMapping("/allowanceCount")
	public Long requestAllowance(@RequestParam("empId") Long empId) {

		LOGGER.info(":: Welcome This is Rest api Allowance Count :::: AllowanceController - requestAllowance ::");
		return allowanceService.findCounts(empId);

	}

}
