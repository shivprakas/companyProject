package com.shiv.interview.project.altimetrikdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;
import com.shiv.interview.project.altimetrikdemo.entity.Project;
import com.shiv.interview.project.altimetrikdemo.exception.RecordNotFoundException;
import com.shiv.interview.project.altimetrikdemo.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Employee> findAllEmployeesByProject(String projcode, String departcode){
		Project p = projectRepository.findByProjcodeAndDeptcode(projcode, departcode);
		if(!ObjectUtils.isEmpty(p)) {
			return p.getEmployees().stream().map(e->new Employee(e.getEmpcode(), e.getEmpname())).collect(Collectors.toList());
		}else {
			throw new RecordNotFoundException("Record not found for project-"+projcode+", departcode-"+departcode);
		}
		
	}
	
	public String dissociateEmployeeFromProject(String projcode, String empcode, String departcode) {
		Project p = projectRepository.findByProjcodeAndDeptcode(projcode, departcode);		
		if(ObjectUtils.isEmpty(p)) {
			throw new RecordNotFoundException("Record not found for project-"+projcode);
		}
		List<Employee> updatedEmployees = p.getEmployees().stream().filter(e-> !e.getEmpcode().equalsIgnoreCase(empcode)).collect(Collectors.toList());
		p.setEmployee(updatedEmployees);
		projectRepository.save(p);
		return "Employee "+empcode+" discotiated from project "+projcode;
	}
}
