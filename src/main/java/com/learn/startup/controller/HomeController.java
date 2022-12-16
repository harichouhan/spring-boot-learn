package com.learn.startup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.service.EmployeeService;
import com.learn.startup.utill.InvalidCacheUtill;
import com.sun.javafx.binding.StringFormatter;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/home")
@SecurityRequirement(name = "bearer-key") 
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private InvalidCacheUtill invalidCacheUtill;

	@GetMapping
	public String home() {
		return "Ram Ram Sa!!";
	}

	@GetMapping("/{name}")
	public String home(@PathVariable String name) {
		return "Ram Ram Sa : " + name;
	}

	@GetMapping("/req")
	public String home(@RequestParam int id) {
		return employeeService.getEmployeeByID(id).toString();
	}

	@GetMapping("/firstName/junk/{junk}")
	public List<String> getFirstNameByJunk(@PathVariable String junk) {
		return employeeService.getFirstNameByJunk(junk);
	}
	
	/**
	 * This API created to invalid cache.
	 * @param cacheName
	 * @return
	 */
	@GetMapping("invalidCache/{cacheName}")
	public String invalidCache(@PathVariable String cacheName) 
	{
		 invalidCacheUtill.evictAllCacheValues(cacheName);
	     return String.format("Invalidated : %s", cacheName); 	
	}
}
