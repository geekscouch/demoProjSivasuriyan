package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeDetails(@PathVariable("id") Integer employeeId) throws Exception {
		Optional<Employee> empDetails=repo.findById(employeeId);
		if(empDetails.isPresent()) {
			return empDetails.get();
		}else {
			throw new Exception();
		}
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee empDetails) {
		
		return repo.save(empDetails);
		
	}

}
