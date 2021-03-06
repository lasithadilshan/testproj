package com.dilshan.testproj.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class LeaveType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type;
	private int leaveCount;
	
	@OneToMany(mappedBy = "leaveType")
	private List<LeaveSummery> leaveSummeries;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public List<LeaveSummery> getLeaves() {
		return leaveSummeries;
	}

	public void setLeaves(List<LeaveSummery> leaveSummeries) {
		this.leaveSummeries = leaveSummeries;
	}

	

}
