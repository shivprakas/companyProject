package com.shiv.interview.project.altimetrikdemo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;
import com.shiv.interview.project.altimetrikdemo.entity.Project;
import com.shiv.interview.project.altimetrikdemo.repository.ProjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	@Mock
	ProjectRepository projectRepository;
	
	
	@Test
	public void test_findAllEmployeesByProject() {
		String projcode = "P1001";
		String departcode = "D101";
		Project p = new Project(projcode, "Name"+projcode, departcode);
		Mockito.when(projectRepository.findByProjcodeAndDeptcode(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(p);
		Assert.assertNotNull(employeeService.findAllEmployeesByProject(projcode, departcode));		
	}
	
	@Test
	public void test_dissociateEmployeeFromProject() {
		String projcode = "P1001";
		String departcode = "D101";
		String empcode = "E10001";
		Project p = new Project(projcode, "Name"+projcode, departcode);
		List<Employee> employees = Arrays.asList(new Employee("E10001", "NameE10001"), new Employee("E10002", "NameE10002"));
		p.setEmployee(employees);
		Mockito.when(projectRepository.findByProjcodeAndDeptcode(projcode, departcode)).thenReturn(p);
		Assert.assertNotNull(employeeService.dissociateEmployeeFromProject(projcode, empcode, departcode));		
	}
}
