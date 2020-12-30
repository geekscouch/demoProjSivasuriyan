package com.example.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controller.EmployeeController;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController empCont;
	
	@Mock
	EmployeeRepo repo;
	
	@Test
	public void testEmployeeDetails() throws Exception {
		Optional<Employee> t=Optional.ofNullable(new Employee());
		Mockito.when(repo.findById(Mockito.any())).thenReturn(t);
		assertEquals(t.get(), empCont.getEmployeeDetails(1));
	}
	@Test(expected = Exception.class)
	public void testEmployeeDetails1() throws Exception {
		Optional<Employee> t=Optional.ofNullable(null);
		Mockito.when(repo.findById(Mockito.any())).thenReturn(t);
		empCont.getEmployeeDetails(1);
	}
	
	@Test
	public void testAddEmployeeDetails() throws Exception {
		Employee empDetails=new Employee();
		empDetails.setDept("");
		empDetails.setId(1);
		empDetails.setManager_name("");
		empDetails.setName("");
		empDetails.setSalary(0);
		Mockito.when(repo.save(Mockito.any())).thenReturn(empDetails);
		assertNotNull(empDetails.getDept());
		assertNotNull(empDetails.getId());
		assertNotNull(empDetails.getManager_name());
		assertNotNull(empDetails.getName());
		assertNotNull(empDetails.getSalary());
		empCont.addEmployee(empDetails);
	}

}
