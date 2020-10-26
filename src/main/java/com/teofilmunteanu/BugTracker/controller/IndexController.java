package com.teofilmunteanu.BugTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController 
{
	/*At the "/" get request, it returns(shows) the "index.html" page*/
	@GetMapping("/")
	public String showIndexPage()
	{
		return "index";
	}
	
	/*At the "/login" get request, it returns(shows) the "loginForm.html" page*/
	@GetMapping("/login")
	public String showLoginForm()
	{
		return "views/loginForm";
	}
}
