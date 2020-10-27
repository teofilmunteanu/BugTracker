package com.teofilmunteanu.BugTracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.teofilmunteanu.BugTracker.domain.Team;

@Controller
public class TeamAssignController 
{
	@PostMapping("/addToTeam")
	public String addToTeam(Team team, BindingResult bindingResult, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "redirect:/users";
		}
		
		return "redirect:/users";
	}
}
