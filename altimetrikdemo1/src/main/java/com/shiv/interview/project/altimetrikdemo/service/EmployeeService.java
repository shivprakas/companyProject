package com.shiv.interview.project.altimetrikdemo.service;

import java.util.List;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployeesByProject(String projcode, String departcode);
	
	String dissociateEmployeeFromProject(String projcode, String empcode, String departcode);
}
