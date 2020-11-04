package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Team 
{
	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String name;	
	
	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
	private List<User> users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TEAM_PROJECTS", 
		joinColumns = { @JoinColumn(name = "TEAM_NAME") }, 
		inverseJoinColumns = { @JoinColumn(name = "PROJECT_NAME") })
	private List<Project> projects;
	
	public Team()
	{
		
	}
	
	public Team(String email, String name, String password) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
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
