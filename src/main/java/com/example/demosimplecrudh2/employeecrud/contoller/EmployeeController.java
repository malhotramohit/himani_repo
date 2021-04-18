package com.example.demosimplecrudh2.employeecrud.contoller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demosimplecrudh2.employeecrud.dto.EmployeeDTO;
import com.example.demosimplecrudh2.employeecrud.service.EmployeeService;

@RestController
@RequestMapping("/empcrud")
public class EmployeeController {

	// save
	// empcrud/employee
	// get all
	// empcrud/

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/employee")
	public ResponseEntity<Object> createEmp(@RequestBody EmployeeDTO employeeDTO) {
		boolean isCreated = employeeService.createEmployee(employeeDTO);
		ResponseEntity<Object> response = null;

		if (isCreated) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{empName}")
					.buildAndExpand(employeeDTO.getEmpName()).toUri();

			System.out.println("fromCurrentRequestUri" + ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());

			System.out.println("fromCurrentContextPath" + ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());

			System.out.println("fromCurrentServletMapping" + ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString());

			response = new ResponseEntity<Object>(uri, HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<Object>("Not Created", HttpStatus.BAD_REQUEST);

		}

		return response;
	}

	@GetMapping("/employee")
	public List<EmployeeDTO> getAllEmps() {
		List<EmployeeDTO> employeeDTOs = employeeService.getAllEmps();
		// if(CollectionUtils.isEmpty(employeeDTOs)) {
		// return ""
		// }

		return employeeDTOs;
	}

	@GetMapping("/employee/{empName}")
	public EmployeeDTO getEmp(@PathVariable(name = "empName") String empName) {

		EmployeeDTO employeeDTO = employeeService.getByName(empName);
		// if(CollectionUtils.isEmpty(employeeDTOs)) {
		// return ""
		// }

		return employeeDTO;
	}

}
