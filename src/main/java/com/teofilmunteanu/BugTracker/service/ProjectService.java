package com.teofilmunteanu.BugTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teofilmunteanu.BugTracker.domain.Project;
import com.teofilmunteanu.BugTracker.domain.ProjectId;
import com.teofilmunteanu.BugTracker.repository.ProjectRepository;

@Service
public class ProjectService
{
	@Autowired
	private ProjectRepository projectRepo;
	
	public void createProject(Project project)
	{
		projectRepo.save(project);
	}
	
	/*Returns the projects with the given string in their name as a List*/
	public List<Project> findByName(String name)
	{
		return projectRepo.findByNameLike("%" + name + "%");
	}
	
	public boolean projectExists(String name, String manager) 
	{
		if(projectRepo.findById((new ProjectId(name, manager))).isPresent())
			return true;
		else
			return false;
	}
}
