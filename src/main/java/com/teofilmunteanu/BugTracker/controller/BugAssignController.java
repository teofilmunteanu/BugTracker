package com.teofilmunteanu.BugTracker.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.teofilmunteanu.BugTracker.domain.Bug;
import com.teofilmunteanu.BugTracker.service.BugService;
import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class BugAssignController 
{
	@Autowired
	private BugService bugService;
	
	@Autowired
	private UserService userService;
	
	/*At the "/addBug" get request, it inserts the user's email(representing the user's ID) into the "email" attribute for the current session, 
	 * it inserts a new "Bug" object into the "bug" attribute
	 * and it returns(shows) the "bugForm.html" page*/
	@GetMapping("/addBug")
	public String bugForm(String email, Model model, HttpSession session)
	{
		session.setAttribute("email", email);
		model.addAttribute("bug", new Bug());
		
		return "views/bugForm";
	}
	
	/*At the "/addBug" post request(when the user adds a bug), if there is an error, it returns(shows) the "bugForm.html" page, 
	 * otherwise, it adds the bug to the selected developer user and it redirects the manager user to the "userList.html" page, through the "/users" get request*/
	@PostMapping("/addBug")
	public String addBug(@Valid Bug bug, BindingResult bindingResult, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/bugForm";
		}
		
		String email = (String)session.getAttribute("email"); 
		bugService.addBug(bug, userService.findOne(email));
		
		return "redirect:/users";
	}
}
