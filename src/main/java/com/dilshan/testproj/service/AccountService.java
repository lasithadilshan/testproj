package com.dilshan.testproj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilshan.testproj.entity.Account;
import com.dilshan.testproj.entity.LeaveType;
import com.dilshan.testproj.repository.AccountRepository;
import com.dilshan.testproj.repository.EmployeeRepository;
import com.dilshan.testproj.repository.LeaveTypeRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	// This is a view data method of Account table
	public List<Account> getAccountList() {

		List<Account> accountList = new ArrayList<>();
		accountRepository.findAll().forEach(Account -> accountList.add(Account));

		for (Iterator<Account> iterator = accountList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();

			System.out.println("*********************************************");
			System.out.println("Account ID     : " + account.getAccountId());
			System.out.println("Employee ID    : " + account.getEmployee().getEmpId());
			System.out.println("Leave ID       : " + account.getLeave().getId());
			System.out.println("Count          : "+account.getCoun());
			System.out.println("*********************************************");

		}

		return accountList;

	}

	public int findCounts(Long empId, Long leaveId) {

		if (accountRepository.findCounts(empId, leaveId) == null) {
			return 0;
		} else {

			int count = accountRepository.findCounts(empId, leaveId);
			System.out.println(count);
			return count;
		}
	}

	public String requestLeave(Long empId, Long leaveId, int count) {

		Account account = new Account();
		account.setCoun(count);
		account.setEmployee(employeeRepository.findById(empId).get());
		account.setLeave(leaveTypeRepository.findById(leaveId).get());

		LeaveType leaveType = leaveTypeRepository.findById(leaveId).get();
		int remaining = leaveType.getLeaveCount() - findCounts(empId, leaveId);

		if (remaining > 0) {
			if (remaining >= count) {

				accountRepository.save(account);

				return "Okey";
			} else {
				return "Leave Count is too high";
			}
		} else {
			return "Alert   !!!!!!   Sorry Your Leaves are over";
		}
	}

}
