package com.example.demosimplecrudh2.employeecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demosimplecrudh2.employeecrud.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	
	public EmployeeModel findByEmpName(String empName);
	
	@Query("select employeeModel from EmployeeModel employeeModel where employeeModel.empName = :empNameParam")
	public EmployeeModel findByEmpSom(@Param(value = "empNameParam") String empNameParam2);
	
}
