package com.learn.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.exception.CustomException;
import com.learn.startup.service.EmployeeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/sort")
@SecurityRequirement(name = "bearer-key")
public class CompareExampleController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/comparable")
	public ResponseEntity<?> createAuthenticationToken() {

		return ResponseEntity.ok(employeeService.getAllEmps());
	}

	@GetMapping("/customException/{isException}")
	public ResponseEntity<?> exceptionTest(@PathVariable Boolean isException) throws CustomException {
		if (isException) {
			throw new CustomException("Error forbidden!!");
		}

		return ResponseEntity.ok("Get it done");
	}

}
