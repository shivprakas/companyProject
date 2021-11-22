package com.shiv.interview.project.altimetrikdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shiv.interview.project.altimetrikdemo.entity.Project;
import com.shiv.interview.project.altimetrikdemo.entity.ProjectId;

@Repository
public interface ProjectRepository extends JpaRepository<Project, ProjectId>{
	
	@Query("select * from PROJECTS p where p.projcode = :projcode and p.deptcode = :deptcode")
	public Project findByProjcodeAndDeptcode(@Param("projcode") String projcode, @Param("deptcode") String deptcode);
}
