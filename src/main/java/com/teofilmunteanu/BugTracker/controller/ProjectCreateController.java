package com.teofilmunteanu.BugTracker.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.teofilmunteanu.BugTracker.domain.Project;
import com.teofilmunteanu.BugTracker.service.ProjectService;

@Controller
public class ProjectCreateController 
{
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/newProject")
	public String teamForm(Model model, HttpSession session, Authentication authentication)
	{
		model.addAttribute("project", new Project());
		session.setAttribute("manager", authentication.getName());
		
		return "views/projectForm";
	}
	
	@PostMapping("/newProject")
	public String createTeam(@Valid Project project, BindingResult bindingResult, Model model, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/projectForm";
		}
		
		project.setManagerEmail((String)session.getAttribute("manager"));
		
		if(projectService.projectExists(project.getName(), project.getManagerEmail()))
		{
			model.addAttribute("projectExists", true);
			
			return "views/projectForm";
		}
			
		projectService.createProject(project);
		
		return "redirect:/projects";
	}
}
