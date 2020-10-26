package com.teofilmunteanu.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class UserListController 
{
	@Autowired
	public UserService userService;
	
	/*At the "/users" get request, it inserts the User object into the "Users" attribute and it returns(shows) the "userList.html" page*/
	@GetMapping("/users")
	public String listUsers(Model model, @RequestParam(defaultValue="") String name)
	{
		model.addAttribute("Users", userService.findByName(name));
		
		return "views/userList";
	}
}
