package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.controller.LeaveSummeryController;
import com.dilshan.testproj.entity.SalaryScale;
import com.dilshan.testproj.repository.SalaryScaleRepository;

@Service
public class SalaryScaleService {
	
	@Autowired
	SalaryScaleRepository salaryScaleRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveSummeryController.class);
	
	
	// This is a rest API method of save SalaryScale
	public SalaryScale saveSalaryScale(SalaryScale salaryScale) {
		LOGGER.info(":: Welcome This is Rest api SalaryScale Saving method :::: SalaryScaleService - saveSalaryScale ::");
		return salaryScaleRepository.save(salaryScale);
		
	}

	
	public List<SalaryScale> getSalaryScaleList() {

		List<SalaryScale> salaryScaleList = new ArrayList<>(salaryScaleRepository.findAll());

		for (SalaryScale salaryScale : salaryScaleList) {

			System.out.println("##################################################################");
			System.out.println("SalaryScale ID             : " + salaryScale.getId());
			System.out.println("Basic Salary               : " + salaryScale.getBasic());
			System.out.println("##################################################################");

		}

		return salaryScaleList;
	}
	
	
	
	

}