package com.teofilmunteanu.BugTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teofilmunteanu.BugTracker.domain.Bug;
import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.repository.BugRepository;

@Service
public class BugService
{
	@Autowired
	private BugRepository bugRepo;
	
	/*Assigns the task to the corresponding user and stores the task data into the database*/
	public void addBug(Bug bug, User user)
	{
		bug.setUser(user);
		bugRepo.save(bug);
	}
	
	/*Returns the tasks of the given user as a List*/
	public List<Bug> findUserBugs(User user)
	{
		return bugRepo.findByUser(user);
	}
}
