package com.teofilmunteanu.BugTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teofilmunteanu.BugTracker.domain.Task;
import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.repository.TaskRepository;

@Service
public class TaskService
{
	@Autowired
	private TaskRepository taskRepo;
	
	/*Assigns the task to the corresponding user and stores the task data into the database*/
	public void addTask(Task task, User user)
	{
		task.setUser(user);
		taskRepo.save(task);
	}
	
	/*Returns the tasks of the given user as a List*/
	public List<Task> findUserTasks(User user)
	{
		return taskRepo.findByUser(user);
	}
}
