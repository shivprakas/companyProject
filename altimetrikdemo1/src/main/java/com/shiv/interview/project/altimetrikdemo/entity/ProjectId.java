package com.shiv.interview.project.altimetrikdemo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "projcode")
	private String projcode;
	
	@Column(name = "deptcode")
  	private String deptcode;

    public ProjectId() {
    }

    public ProjectId(String projcode, String deptcode) {
 		this.projcode = projcode;
 		this.deptcode = deptcode;
 	}

    public String getProjcode() {
  		return projcode;
  	}

  	public void setProjcode(String projcode) {
  		this.projcode = projcode;
  	}

  	public String getDeptcode() {
  		return deptcode;
  	}

  	public void setDeptcode(String deptcode) {
  		this.deptcode = deptcode;
  	}
  	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        ProjectId projectId = (ProjectId) o;
        
        return this.projcode.equals(projectId.getProjcode()) && this.deptcode.equals(projectId.getDeptcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(projcode, deptcode);
    }
}