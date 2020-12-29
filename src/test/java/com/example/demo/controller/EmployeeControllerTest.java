package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DemoApplication;
import com.example.demo.Controller.EmployeeController;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController empCont;
	
	@Mock
	EmployeeRepo repo;
	
	
	final String url="http://localhost:8080/employee";
	
	
	/*
	 * @Test public void getEmployeeDetailsTest() throws URISyntaxException {
	 * RestTemplate restTemplate=new RestTemplate(); URI uri=new URI(url+"/0");
	 * ResponseEntity<Employee> response=restTemplate.getForEntity(uri,
	 * Employee.class); assertEquals(0, response.getBody().getId());
	 * 
	 * }
	 */
	
	@Test
	public void testEmployeeDetails() throws Exception {
		EmployeeController cont=new EmployeeController();
		
		//Mockito.when(repo.findById(Mockito.any())).thenReturn(null);
		assertEquals("Employee not found", cont.getEmployeeDetails(1));
		
	}

}
