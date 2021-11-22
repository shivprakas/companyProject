package com.shiv.interview.project.altimetrikdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;
import com.shiv.interview.project.altimetrikdemo.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeRestControllerTest {

	@InjectMocks
	EmployeeRestController employeeRestController;
	
	@Mock
	EmployeeService employeeService;
	
	
	@Test
	public void test_getEmployeesByProject() {
		String projcode = "P1001";
		String departcode = "D101";
		List<Employee> empList = Arrays.asList(new Employee("E10001", "NameE10001"));
		Mockito.when(employeeService.findAllEmployeesByProject(projcode, departcode)).thenReturn(empList);
		Assert.assertNotNull(employeeRestController.getEmployeesByProject(projcode, departcode));		
	}
	
	@Test
	public void test_dissociateEmployeeFromProject() {
		String projcode = "P1001";
		String departcode = "D101";
		String empcode = "E10001";
		String message = "successfully dissociated";
		Mockito.when(employeeService.dissociateEmployeeFromProject(projcode, empcode, departcode)).thenReturn(message);
		Assert.assertNotNull(employeeRestController.dissociateEmployeeFromProject(projcode, empcode, departcode));		
	}
	
}
