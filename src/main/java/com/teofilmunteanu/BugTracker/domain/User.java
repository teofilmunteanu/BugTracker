package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class User 
{
	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min = 6)
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Task> tasks;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", 
	joinColumns = 
	{
		@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")
	}, 
	inverseJoinColumns = 
	{
		@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")
	})
	private List<Role> roles;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_TEAMS", 
	joinColumns = 
	{
		@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")
	}, 
	inverseJoinColumns = 
	{
		@JoinColumn(name = "TEAM_NAME", referencedColumnName = "name")
	})
	private List<Team> teams;
	
	public User()
	{
		
	}

	public User(String email, String name, String password) 
	{
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public List<Team> getTeams() 
	{
		return teams;
	}

	public void setTeams(List<Team> teams) 
	{
		this.teams = teams;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public List<Task> getTask() 
	{
		return tasks;
	}
	public void setTask(List<Task> tasks) 
	{
		this.tasks = tasks;
	}
	public List<Role> getRoles() 
	{
		return roles;
	}
	public void setRoles(List<Role> roles) 
	{
		this.roles = roles;
	}
	
}
