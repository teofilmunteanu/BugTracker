package com.teofilmunteanu.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teofilmunteanu.BugTracker.service.ProjectService;

@Controller
public class ProjectListController 
{
	@Autowired
	public ProjectService projectService;
	
	/*At the "/projects" get request, it inserts the User object into the "Projects" attribute and it returns(shows) the "projectList.html" page*/
	@GetMapping("/projects")
	public String listTeams(Model model, @RequestParam(defaultValue="") String name)
	{
		model.addAttribute("Projects", projectService.findByName(name));
		
		return "views/projectList";
	}
	
	@RequestMapping("/deleteProject")
	public String deleteProject(String name, Authentication authentication)
	{
		projectService.deleteProject(name, authentication.getName());
		
		return "redirect:/projects";
	}
}