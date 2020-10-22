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
	
	public void addTask(Task task, User user)
	{
		task.setUser(user);
		taskRepo.save(task);
	}
	
	public List<Task> findUserTask(User user)
	{
		return taskRepo.findByUser(user);
	}
}
