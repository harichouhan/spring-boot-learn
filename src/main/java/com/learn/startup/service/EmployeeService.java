package com.learn.startup.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.startup.model.Employee;
import com.learn.startup.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<Employee> getEmployeeByID(Integer id) {
		return employeeRepository.findById(id);
	}

	/**
	 * This Method gives all the first name based on the junk.
	 * 
	 * @param junk : Parameter for junk type.
	 * @return : List of first name.
	 */
	
	public List<String> getFirstNameByJunk(String junk) {
		return employeeRepository.findFirstNameByJunk(junk);
	}
	
	public List<Employee> getAllEmps()
	{
	
		List<Employee> emps = employeeRepository.getAll();
		Collections.sort(emps);
		return emps;
		
	}
}
