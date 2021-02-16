package com.dilshan.testproj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    private int coun;
    
    @ManyToOne
    private Employee employee;
    
    @ManyToOne
    private LeaveType leaveType;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	public int getCoun() {
		return coun;
	}

	public void setCoun(int coun) {
		this.coun = coun;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveType getLeave() {
		return leaveType;
	}

	public void setLeave(LeaveType leaveType) {
		this.leaveType = leaveType;
	}


	
}
