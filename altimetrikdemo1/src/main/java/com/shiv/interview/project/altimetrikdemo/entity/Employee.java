package com.shiv.interview.project.altimetrikdemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "empcode")
	private String empcode;

	@Column(name = "empname")
	private String empname;

	@MapsId("projectId")
	@ManyToMany(targetEntity = Project.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	@JoinTable(
	        name="EMPLOYEES_PROJECTS",
	        joinColumns=
	        {@JoinColumn( name="projcode", referencedColumnName="empcode"),
	        @JoinColumn( name="deptcode", referencedColumnName="empcode")},
	        inverseJoinColumns=
	        	{@JoinColumn(name="empcode", columnDefinition = "projectId" )
	        	//,@JoinColumn(name="empcode", referencedColumnName="deptcode" ) 
	        		})                 
	private List<Project> projects = new ArrayList<Project>();

	@ManyToMany(targetEntity = Department.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	@JoinTable(
	        name="EMPLOYEES_DEPARTMENTS",
	        joinColumns=
	        @JoinColumn( name="deptcode", referencedColumnName="empcode"),
	        inverseJoinColumns=@JoinColumn(name="empcode", referencedColumnName="deptcode"))                 
	private List<Project> departments = new ArrayList<Project>();
	
	public Employee() {	}

	public Employee(String empcode, String empname) {
		this.empcode = empcode;
		this.empname = empname;
	}
	
	public Employee(String empcode, String empname, List<Project> projects) {
		this.empcode = empcode;
		this.empname = empname;
		this.projects = projects;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Project> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Project> departments) {
		this.departments = departments;
	}
	
}
