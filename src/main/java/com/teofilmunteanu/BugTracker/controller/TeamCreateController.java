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

import com.teofilmunteanu.BugTracker.domain.Team;
import com.teofilmunteanu.BugTracker.service.TeamService;

@Controller
public class TeamCreateController 
{
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/newTeam")
	public String teamForm(Model model, HttpSession session, Authentication authentication)
	{
		model.addAttribute("team", new Team());
		session.setAttribute("manager", authentication.getName());
		
		return "views/teamForm";
	}
	
	@PostMapping("/newTeam")
	public String createTeam(@Valid Team team, BindingResult bindingResult, Model model, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/teamForm";
		}
		
		team.setManagerEmail((String)session.getAttribute("manager"));

		if(teamService.teamExists(team.getName(), team.getManagerEmail()))
		{
			model.addAttribute("teamExists", true);
			
			return "views/teamForm";
		}
		
		teamService.createTeam(team);

		return "redirect:/teams";
	}
}
