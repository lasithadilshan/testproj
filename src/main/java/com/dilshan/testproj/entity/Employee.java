package com.dilshan.testproj.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
	private String nIC;
	private String name;
	private int age;
	private String email;
	private int contactNumber;
	
	@OneToMany(mappedBy = "employee")
	private List<LeaveSummery> leaveSummeries;
	
	@ManyToOne
	private SalaryScale salaryScales;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getnIC() {
		return nIC;
	}

	public void setnIC(String nIC) {
		this.nIC = nIC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<LeaveSummery> getLeaves() {
		return leaveSummeries;
	}

	public void setLeaves(List<LeaveSummery> leaveSummeries) {
		this.leaveSummeries = leaveSummeries;
	}

	public SalaryScale getSalaryScales() {
		return salaryScales;
	}

	public void setSalaryScales(SalaryScale salaryScales) {
		this.salaryScales = salaryScales;
	}

	

}
