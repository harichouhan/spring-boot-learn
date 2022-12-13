package com.learn.startup;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.startup.model.Employee;
import com.learn.startup.service.EmployeeService;

@SpringBootTest
public class EmployeeTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	void isEmployeeExist()
	{
		Optional<Employee> employee = employeeService.getEmployeeByID(1);
		
		assertNotNull(employee);
		
	}
	

}
