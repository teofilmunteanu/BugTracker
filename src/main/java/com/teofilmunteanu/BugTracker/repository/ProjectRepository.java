package com.teofilmunteanu.BugTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Project;
import com.teofilmunteanu.BugTracker.domain.ProjectId;

public interface ProjectRepository extends JpaRepository<Project, ProjectId>{

	List<Project> findByNameLike(String name);
	
}
