package com.teofilmunteanu.BugTracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.teofilmunteanu.BugTracker.domain.Team;
import com.teofilmunteanu.BugTracker.service.TeamService;

@Controller
public class TeamAssignController 
{
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/addToTeam")
	public String addToTeam(Team team, BindingResult bindingResult, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			
		}
		
		return "redirect:/teams";
	}
}
