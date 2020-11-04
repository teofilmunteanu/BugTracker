package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project 
{
	@Id
	private String name;
	
	private String due_to;
	
	private String status;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Bug> bugs;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	private List<User> users;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	private List<Team> teams;
	
	public Project() 
	{
		
	}

	public Project(String name, String due_to, String status) 
	{
		this.name = name;
		this.due_to = due_to;
		this.status = status;
	}
	
	public Project(String name, String due_to, String status, List<User> users) 
	{
		this.name = name;
		this.due_to = due_to;
		this.status = status;
		this.users = users;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDue_to()
	{
		return due_to;
	}

	public void setDue_to(String due_to) 
	{
		this.due_to = due_to;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users) 
	{
		this.users = users;
	}
	
	
}
