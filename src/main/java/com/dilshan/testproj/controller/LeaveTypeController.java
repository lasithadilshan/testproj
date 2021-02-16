package com.dilshan.testproj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.testproj.entity.LeaveType;
import com.dilshan.testproj.service.LeaveTypeService;

@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveTypeController.class);
	
	@Autowired
	LeaveTypeService leaveTypeService;
	
	@PostMapping("/")
	public LeaveType saveLeaveType(@RequestBody LeaveType leaveType) {

		LOGGER.info(":: Welcome This is Rest api LeaveType Saving :::: LeaveTypeController - saveLeaveType ::");
		return leaveTypeService.saveLeaveType(leaveType);

	}
	
	@GetMapping("/")
	public List<LeaveType> getleaveTypesList() {
		LOGGER.info(":: read leaveTypesList :::: LeaveTypeController - getleaveTypesList ::");
		return leaveTypeService.getleaveTypesList();
	}

}
