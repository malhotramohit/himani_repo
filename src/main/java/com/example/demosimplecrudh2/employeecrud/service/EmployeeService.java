package com.example.demosimplecrudh2.employeecrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demosimplecrudh2.employeecrud.dto.EmployeeDTO;
import com.example.demosimplecrudh2.employeecrud.model.EmployeeModel;
import com.example.demosimplecrudh2.employeecrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public boolean createEmployee(EmployeeDTO employeeDTO) {

		boolean isRecordCreated = false;

		EmployeeModel employeeModel = new EmployeeModel(employeeDTO.getEmpName(), employeeDTO.getAge());
		EmployeeModel employeeModelFromDB = employeeRepository.save(employeeModel);
		if (null != employeeModelFromDB.getEmpId()) {
			isRecordCreated = true;
		}
		return isRecordCreated;

	}

	public List<EmployeeDTO> getAllEmps() {
		List<EmployeeModel> employeeModels = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = null;
		EmployeeDTO employeeDTO;

		if (null != employeeModels) {
			employeeDTOs =  new ArrayList<EmployeeDTO>();
			for (EmployeeModel employeeModel : employeeModels) {
				employeeDTO = new EmployeeDTO(employeeModel.getEmpName(), employeeModel.getAge());
				employeeDTOs.add(employeeDTO);
			}
		}
		
		
		return employeeDTOs;
	}
	
	
	public EmployeeDTO getByName(String empName) {
		
		EmployeeModel employeeModel = employeeRepository.findByEmpSom(empName);
		
		EmployeeDTO dto =  new EmployeeDTO(employeeModel.getEmpName(), employeeModel.getAge());
		return dto;
		
	}

}
