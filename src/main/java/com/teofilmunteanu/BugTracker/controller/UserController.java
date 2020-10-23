package com.teofilmunteanu.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	public UserService userService;
	
	@GetMapping("/users")
	public String listUsers(Model model, @RequestParam(defaultValue="") String name)
	{
		model.addAttribute("users", userService.findByName(name));
		return "views/list";
	}
}
