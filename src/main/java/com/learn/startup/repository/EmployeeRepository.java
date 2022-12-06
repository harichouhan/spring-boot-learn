package com.learn.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.startup.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	/**
	 * This Method gives all the first name based on the junk.
	 * 
	 * @param junk : Parameter for junk type.
	 * @return : List of first name.
	 */
	@Query(value="SELECT firstName from Employee where junk=:junk")
	List<String> findFirstNameByJunk(@Param("junk")String junk);
	
	@Query(value="SELECT emp from Employee emp")
	List<Employee> getAll();
	
}
