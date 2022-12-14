package com.learn.startup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.learn.startup.repository.EmployeeRepository;
import com.learn.startup.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeMockTest {

	@MockBean
	EmployeeRepository employeeRepo;

	@Autowired
	EmployeeService employeeService;

	@Test
	void test() {
		List<String> empsJunk = new ArrayList<>();
		empsJunk.add("junk");
		empsJunk.add("junk");
		String fname = "hari";

		when(employeeRepo.findFirstNameByJunk(fname)).thenReturn(empsJunk);

		System.out.println("Test done.");

		int count = employeeService.getFirstNameByJunk(fname).size();

		 assertEquals(2, count);
	}
}
