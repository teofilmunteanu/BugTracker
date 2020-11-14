package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
@IdClass(ProjectId.class)
public class Project 
{
	@Id
	private String managerEmail;
	
	@Id
	@NotEmpty
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

	public String getManagerEmail() 
	{
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) 
	{
		this.managerEmail = managerEmail;
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
	

	public List<Bug> getBugs() 
	{
		return bugs;
	}

	public void setBugs(List<Bug> bugs) 
	{
		this.bugs = bugs;
	}

	public List<Team> getTeams() 
	{
		return teams;
	}

	public void setTeams(List<Team> teams) 
	{
		this.teams = teams;
	}
}
