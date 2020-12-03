package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@IdClass(TeamId.class)
public class Team
{	
	@Id
	private String managerEmail;

	@Id
	@NotEmpty
	private String name;	

	private int nrOfMembers;
	
	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
	private List<User> users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TEAM_PROJECTS", 
		joinColumns = { @JoinColumn(name = "TEAM_MANAGER"), @JoinColumn(name = "TEAM_NAME") }, 
		inverseJoinColumns = { @JoinColumn(name = "PROJECT_MANAGER"), @JoinColumn(name = "PROJECT_NAME") })//{ @JoinColumn(name = "PROJECT_ID")})
	private List<Project> projects;
	
	public Team()
	{
		
	}
	
	public Team(String name) 
	{
		this.name = name;
		//this.nrOfMembers = 0;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getManagerEmail() 
	{
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) 
	{
		this.managerEmail = managerEmail;
	}
	
	public int getNrOfMembers() 
	{
		return nrOfMembers;
	}

	public void setNrOfMembers(int nrOfMembers) 
	{
		this.nrOfMembers = nrOfMembers;
	}

	public List<User> getUsers() 
	{
		return users;
	}

	public void setUsers(List<User> users) 
	{
		this.users = users;
	}

	public List<Project> getProjects() 
	{
		return projects;
	}

	public void setProjects(List<Project> projects) 
	{
		this.projects = projects;
	}
}
