package com.example.demosimplecrudh2.employeecrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
	private String empName;
	private int age;
	
	

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public EmployeeModel(String empName, int age) {
		super();
		this.empName = empName;
		this.age = age;
	}



	public EmployeeModel(Long empId, String empName, int age) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
