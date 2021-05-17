package com.uday.springcrudopr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="eemployee")
@Data
public class Employee {
	
	@Id
	@Column(name="empid")
	private Long empid;
	
	public Employee() {
		super();
	}

	@Column(name="empname")
	private String empname;
	
	@Column(name="locationcode")
	private String locationcode;
  
	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getLocationcode() {
		return locationcode;
	}

	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Column(name="location")
	private String location;
	
	@Column(name="date")
	private String date;
	
	@Column(name="salary")
	private String salary;
  

 
}
