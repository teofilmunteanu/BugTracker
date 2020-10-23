package com.teofilmunteanu.BugTracker.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.service.TaskService;
import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class ProfileController 
{
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userService.findOne(email);
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		
		return "views/profile";
	}

}
