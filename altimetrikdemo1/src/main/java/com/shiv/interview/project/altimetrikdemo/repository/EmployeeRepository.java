package com.shiv.interview.project.altimetrikdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiv.interview.project.altimetrikdemo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
}
