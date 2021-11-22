package com.shiv.interview.project.altimetrikdemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.shiv.interview.project.altimetrikdemo.entity.Department;
import com.shiv.interview.project.altimetrikdemo.entity.Employee;
import com.shiv.interview.project.altimetrikdemo.entity.Project;
import com.shiv.interview.project.altimetrikdemo.repository.DepartmentRepository;
import com.shiv.interview.project.altimetrikdemo.repository.EmployeeRepository;
import com.shiv.interview.project.altimetrikdemo.repository.ProjectRepository;

@ComponentScan(basePackages = "com.shiv.interview.project.altimetrikdemo")
@SpringBootApplication
public class AltimetrikdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltimetrikdemoApplication.class, args);
	}

	
	@Bean
    public CommandLineRunner mappingDemo(
    		EmployeeRepository employeeRepository,
    		ProjectRepository projectRepository,
    		DepartmentRepository departmentRepository) {
        return args -> {
        	
		Employee e1 = new Employee("E10001", "NameE10001");
		Employee e2 = new Employee("E10002", "NameE10002");
		Employee e3 = new Employee("E10003", "NameE10003");
		Employee e4 = new Employee("E10004", "NameE10004");
		Employee e5 = new Employee("E10005", "NameE10005");		
		employeeRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
    		
        Department d1 = new Department("D101", "NameD101");	
        Department d2 = new Department("D102", "NameD102");	
        departmentRepository.saveAll(Arrays.asList(d1, d2));
		
		Project p1 = new Project("P1001", "NameP1001", "D101");
		Project p2 = new Project("P1002", "NameP1002", "D101");
		projectRepository.saveAll(Arrays.asList(p1,p2));
		
		p1.getEmployees().addAll(Arrays.asList(e1, e2, e4));
		projectRepository.save(p1);
		p2.getEmployees().addAll(Arrays.asList(e1, e3, e5));
		projectRepository.save(p2);
		
		e1.getProjects().add(p1);
		e1.getProjects().add(p2);
		employeeRepository.saveAll(Arrays.asList(e1, e2));
		
		e2.getProjects().add(p1);
		e3.getProjects().add(p2);
		employeeRepository.saveAll(Arrays.asList(e2, e3));
		
		e4.getProjects().add(p1);
		e5.getProjects().add(p2);
		employeeRepository.saveAll(Arrays.asList(e4, e5));		
        };
	}
	

}
