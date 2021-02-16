package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.entity.LeaveType;
import com.dilshan.testproj.repository.LeaveTypeRepository;

@Service
public class LeaveTypeService {
	
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	
	
	//This is LeaveType table data saving method
	public void saveData() {
		
		LeaveType leaveType1 = new LeaveType();
		leaveType1.setType("Sick Leave");
		leaveType1.setLeaveCount(10);
		leaveTypeRepository.save(leaveType1);
		
		LeaveType leaveType2 = new LeaveType();
		leaveType2.setType("Casual Leave");
		leaveType2.setLeaveCount(8);
		leaveTypeRepository.save(leaveType2);
		
		LeaveType leaveType3 = new LeaveType();
		leaveType3.setType("Maternity leave");
		leaveType3.setLeaveCount(9);
		leaveTypeRepository.save(leaveType3);

		LeaveType leaveType4 = new LeaveType();
		leaveType4.setType("Bereavement leave");
		leaveType4.setLeaveCount(5);
		leaveTypeRepository.save(leaveType4);
		
		LeaveType leaveType5 = new LeaveType();
		leaveType5.setType("Compensatory leave");
		leaveType5.setLeaveCount(4);
		leaveTypeRepository.save(leaveType5);
		
	}
	
	
	
	public LeaveType saveLeaveType(LeaveType leaveType) {

		return leaveTypeRepository.save(leaveType);

	}
	
	
	// This is a save data method of Leave Types table
	public List<LeaveType> getleaveTypesList() {
		
		List<LeaveType> leaveTypesList = new ArrayList<>();
		leaveTypeRepository.findAll().forEach(LeaveType -> leaveTypesList.add(LeaveType));

		for (Iterator<LeaveType> iterator = leaveTypesList.iterator(); iterator.hasNext();) {
			LeaveType leaveType = (LeaveType) iterator.next();

			System.out.println("*********************************************");
			System.out.println("Leave ID     : "+leaveType.getId());
			System.out.println("Leave Type  : "+leaveType.getType());
			System.out.println("Leave Count  : "+leaveType.getLeaveCount());
			System.out.println("*********************************************");

		}

		return leaveTypesList;
		
	}

}
