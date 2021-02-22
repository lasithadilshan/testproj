package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.entity.LeaveSummery;
import com.dilshan.testproj.entity.LeaveType;
import com.dilshan.testproj.repository.LeaveSummeryRepository;
import com.dilshan.testproj.repository.EmployeeRepository;
import com.dilshan.testproj.repository.LeaveTypeRepository;

@Service
public class LeaveSummeryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveSummeryService.class);

	@Autowired
	LeaveSummeryRepository leaveSummeryRepository;

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	// This is a view data method of Account table
	public List<LeaveSummery> getAccountList() {

		List<LeaveSummery> accountList = new ArrayList<>();
		leaveSummeryRepository.findAll().forEach(Account -> accountList.add(Account));

		for (Iterator<LeaveSummery> iterator = accountList.iterator(); iterator.hasNext();) {
			LeaveSummery leaveSummery = (LeaveSummery) iterator.next();

			LOGGER.info(":: read Leave Summery :::: AccountController - getAccountList ::");
			System.out.println("*********************************************");
			System.out.println("Leave ID       : " + leaveSummery.getId());
			System.out.println("Employee ID    : " + leaveSummery.getEmployee().getEmpId());
			System.out.println("Leave Type ID  : " + leaveSummery.getLeaveType().getId());
			System.out.println("Count          : " + leaveSummery.getCount());
			System.out.println("*********************************************");

		}

		return accountList;

	}

	public int findCounts(Long empId, Long leaveId) {

		if (leaveSummeryRepository.findCounts(empId, leaveId) == null) {
			return 0;
		} else {

			int count = leaveSummeryRepository.findCounts(empId, leaveId);
			System.out.println(count);
			return count;
		}
	}

	public String requestLeave(Long empId, Long leaveId, int count) {

		LeaveSummery leave = new LeaveSummery();
		leave.setCount(count);
		leave.setEmployee(employeeRepository.findById(empId).get());
		leave.setLeaveType(leaveTypeRepository.findById(leaveId).get());

		LeaveType leaveType = leaveTypeRepository.findById(leaveId).get();
		int remaining = leaveType.getLeaveCount() - findCounts(empId, leaveId);

		if (remaining > 0) {
			if (remaining >= count) {

				leaveSummeryRepository.save(leave);

				return "Accepted";
			} else {
				return "Avaliable Leave Count is not sufficient";
			}
		} else {
			return "Alert   !!!!!!   Sorry Your Leaves are over";
		}
	}

}
