package com.learn.startup.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee implements Comparable<Employee>{
	
    @Id
    @Column(name="employee_id")
    private Integer employeeID;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="date_of_birth")
    private String dateOfBirth;
    
    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name="junk")
    private String junk;

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJunk() {
		return junk;
	}

	public void setJunk(String junk) {
		this.junk = junk;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", junk=" + junk + "]";
	}

	@Override
	public int compareTo(Employee o) {
		
		return getFirstName().compareTo(o.firstName);
	}
    
    
    
 
}