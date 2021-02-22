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

import com.dilshan.testproj.entity.SalaryScale;
import com.dilshan.testproj.service.SalaryScaleService;

@RestController
@RequestMapping("/salaryScale")
public class SalaryScaleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SalaryScaleController.class);
	
	@Autowired
	SalaryScaleService salaryScaleService;

	@PostMapping("/")
	public SalaryScale saveSalaryScale(@RequestBody SalaryScale salaryScale) {

		LOGGER.info(":: Welcome This is Rest api SalaryScale Saving :::: SalaryScaleController - saveSalaryScale ::");
		return salaryScaleService.saveSalaryScale(salaryScale);

	}
	
	@GetMapping("/")
	public List<SalaryScale> readSalaryScale() {
		LOGGER.info(":: read salaryScale :::: SalaryScaleController - readSalaryScale ::");
		return salaryScaleService.getSalaryScaleList();
	}

}
