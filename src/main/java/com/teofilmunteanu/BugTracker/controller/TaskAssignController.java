package com.teofilmunteanu.BugTracker.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.teofilmunteanu.BugTracker.domain.Task;
import com.teofilmunteanu.BugTracker.service.TaskService;
import com.teofilmunteanu.BugTracker.service.UserService;

@Controller
public class TaskAssignController 
{
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	/*At the "/addTask" get request, it inserts the user's email(representing the user's ID) into the "Email" attribute for the current session, 
	 * it inserts a new "Task" object into the "Task" attribute
	 * and it returns(shows) the "taskForm.html" page*/
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session)
	{
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/taskForm";
	}
	
	/*At the "/addTask" post request(when the manager user adds a task), if there is an error, it returns(shows) the "taskForm.html" page, 
	 * otherwise, it adds the task to the selected developer user and it redirects the manager user to the "userList.html" page, through the "/users" get request*/
	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/taskForm";
		}
		
		String email = (String)session.getAttribute("email"); 
		taskService.addTask(task, userService.findOne(email));
		
		return "redirect:/users";
	}
}
