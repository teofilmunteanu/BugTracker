package com.teofilmunteanu.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teofilmunteanu.BugTracker.service.TeamService;

@Controller
public class TeamListController 
{
	@Autowired
	public TeamService teamService;
	
	/*At the "/teams" get request, it inserts the User object into the "Teams" attribute and it returns(shows) the "teamList.html" page*/
	@GetMapping("/teams")
	public String listTeams(Model model, @RequestParam(defaultValue="") String name)
	{
		model.addAttribute("Teams", teamService.findByName(name));
		
		return "views/teamList";
	}
}