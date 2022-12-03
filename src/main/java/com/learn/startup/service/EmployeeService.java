package com.learn.startup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.startup.model.Employee;
import com.learn.startup.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployeeByID(Integer id)
	{
		return employeeRepository.findById(id);
	}
}
