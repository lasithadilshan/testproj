package com.dilshan.testproj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.testproj.entity.LeaveSummery;
import com.dilshan.testproj.service.LeaveSummeryService;

@RestController
@RequestMapping("/leave")
public class LeaveSummeryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveSummeryController.class);
	
	@Autowired
	LeaveSummeryService leaveSummeryService;
	
	
	@GetMapping("/")
	public List<LeaveSummery> getAccountList() {
		LOGGER.info(":: read account :::: AccountController - getAccountList ::");
		return leaveSummeryService.getAccountList();
	}
	
	
	@PostMapping("/")
	public String requestLeave(@RequestParam("empId") Long empId,@RequestParam("leaveId") Long leaveId,@RequestParam("count") int count) {

		LOGGER.info(":: Welcome This is Rest api Request Leave :::: AccountController - requestLeave ::");
		return leaveSummeryService.requestLeave(empId,leaveId,count);

	}

}
