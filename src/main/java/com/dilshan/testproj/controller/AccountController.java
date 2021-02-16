package com.dilshan.testproj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.testproj.entity.Account;
import com.dilshan.testproj.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	
	@GetMapping("/")
	public List<Account> getAccountList() {
		LOGGER.info(":: read account :::: AccountController - getAccountList ::");
		return accountService.getAccountList();
	}
	
	
	
//	@GetMapping("/empId/{empId}/leaveId/{leaveId}/coun/{coun}")
//	public String findByAccounts(@PathVariable("empId") Long empId,@PathVariable("leaveId") Long leaveId,@PathVariable("coun") int coun) {
//		try {
//			
//			LOGGER.info(":: Welcome ! This is Account counter :::: AccountController - findByAccounts ::");
//			
//			return accountService.findByAccounts(empId,leaveId,coun);
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			e.getMessage();
//			
//			LOGGER.info(":: This is Leaves Counter Error :::: AccountController - findByAccounts ::");
//			return null;
//		}
//	}
	
	@PostMapping("/")
	public String requestLeave(@RequestParam("empId") Long empId,@RequestParam("leaveId") Long leaveId,@RequestParam("count") int count) {

		LOGGER.info(":: Welcome This is Rest api Account Saving :::: AccountController - saveAccount ::");
		return accountService.requestLeave(empId,leaveId,count);

	}

}
