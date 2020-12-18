package com.teofilmunteanu.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.teofilmunteanu.BugTracker.service.BugService;

@Controller
public class TeamPageController 
{
	@Autowired
	BugService bugService;
	
	@GetMapping("/team/{managerEmail}/{name}") //make it work only for the manager's teams
	public String teamPage(@PathVariable String managerEmail, @PathVariable String team)
	{	
		return "views/teamList";
	}
}
