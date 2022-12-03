package com.learn.startup.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.service.EmployeeService;

@RestController
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String home() 
	{
		return "Ram Ram Sa!!";
	}
	
	@GetMapping("/home/{name}")
	public String home(@PathVariable String name) 
	{
		return "Ram Ram Sa : " + name; 
	}
	
	@GetMapping("/home/req")
	public String home(@RequestParam int id) 
	{
		return employeeService.getEmployeeByID(id).toString(); 
	}
}
