package com.shiv.interview.project.altimetrikdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;
import com.shiv.interview.project.altimetrikdemo.service.EmployeeService;

/**
 * 
 * @author shivp
 *
 */
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @param projcode
	 * @return
	 */
	@GetMapping(value = "/employees/{projcode}/{deptcode}", produces = "application/json")
	 public List<Employee> getEmployeesByProject(@PathVariable String projcode, @PathVariable String deptcode) {
		return employeeService.findAllEmployeesByProject(projcode, deptcode);
	}
	
	@DeleteMapping(value = "/employees/{projcode}/{empcode}/{deptcode}", produces = "application/json")
	 public String dissociateEmployeeFromProject(@PathVariable String projcode, @PathVariable String empcode, @PathVariable String deptcode) {
		return employeeService.dissociateEmployeeFromProject(projcode, empcode, deptcode);
	}
}
