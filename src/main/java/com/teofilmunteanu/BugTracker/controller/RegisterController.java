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

import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class RegisterController 
{
	@Autowired
	private UserService userService;
	
	/*At the "/register" get request, it inserts a new "User" object into the "user" attribute 
	 * and returns(shows) the "registerForm.html" page*/
	@GetMapping("/register")
	public String registerForm(Model model, HttpSession session, Authentication authentication)
	{
		model.addAttribute("user", new User());
		if(authentication == null)
		{
			session.setAttribute("manager", null);
		}
		else
		{
			session.setAttribute("manager", authentication.getName());
		}
			
		return "views/registerForm";
	}

	/*At the "/register" post request(when the user submits the registration), 
	 * if there is an error or the email is already registered in the database, it returns(shows) the "registerForm.html" page, 
	 * otherwise, it creates a new user with the given credentials and returns(shows) the "registerSuccess.html" page*/
	@PostMapping("/register")
	public String registerManager(@Valid User user, BindingResult bindingResult, Model model, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/registerForm";
		}
		if(userService.userExists(user.getEmail()))
		{
			model.addAttribute("emailExists", true); 
			
			return "views/registerForm"; 
		}
		
		user.setName(user.getFirstName() + ' ' + user.getLastName());
		
		
		if((String)session.getAttribute("manager") == null)
		{
			user.setManagerEmail(user.getEmail());
			userService.createManager(user); 
		}
		else
		{
			user.setManagerEmail((String)session.getAttribute("manager"));
			userService.createDeveloper(user);
		}
		
		return "views/registerSuccess"; 
	}
}
