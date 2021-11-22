package com.shiv.interview.project.altimetrikdemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTS")
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    public ProjectId projectId;

	private String projname;	

	@ManyToMany(targetEntity = Employee.class, mappedBy = "projects", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Employee> employees = new ArrayList<Employee>();

	public Project() {	}//
	
	
	public Project(String projcode, String projname, String deptcode) {
		this.projectId = new ProjectId(projcode, deptcode);
		this.projname = projname;
	}
	
	
	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}	
	
	public ProjectId getProjectId() {
		return projectId;
	}


	public void setProjectId(ProjectId projectId) {
		this.projectId = projectId;
	}
	

}
