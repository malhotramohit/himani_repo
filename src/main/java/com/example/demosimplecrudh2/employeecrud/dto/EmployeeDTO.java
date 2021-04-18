package com.example.demosimplecrudh2.employeecrud.dto;

public class EmployeeDTO {

	private String empName;
	private int age;

	public EmployeeDTO(String empName, int age) {
		super();
		this.empName = empName;
		this.age = age;
	}
	
	

	public EmployeeDTO() {
		super();
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
