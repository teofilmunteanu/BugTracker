package com.teofilmunteanu.BugTracker.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.service.BugService;
import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class BugListController 
{
	
	@Autowired
	private BugService bugService;
	@Autowired
	private UserService userService;
	
	/*At the "/bugs" get request, it inserts the currently authenticated user's assigned bugs into the "Bugs" attribute 
	 * and returns(shows) the "bugList.html" page*/
	@GetMapping("/bugs")
	public String showProfilePage(Model model, Principal principal) 
	{
		String email = principal.getName();
		User user = userService.findOne(email);
		
		model.addAttribute("Bugs", bugService.findUserBugs(user)); 
		model.addAttribute("Username", user.getName());
		
		return "views/bugList";
	}

}
