package com.learn.startup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.service.EmployeeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private EmployeeService employeeService;

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
}
