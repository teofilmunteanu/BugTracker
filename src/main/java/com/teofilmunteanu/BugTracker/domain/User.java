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
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	private String name;
	
	@Size(min = 6)
	private String password;
	
	private String managerEmail;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Bug> bugs;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", 
		joinColumns = { @JoinColumn(name = "USER_EMAIL") }, 
		inverseJoinColumns = { @JoinColumn(name = "ROLE_NAME") })
	private List<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_PROJECTS", 
		joinColumns = { @JoinColumn(name = "USER_EMAIL") }, 
		inverseJoinColumns = { @JoinColumn(name = "PROJECT_NAME") })
	private List<Project> projects;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_TEAMS", 
		joinColumns = { @JoinColumn(name = "USER_EMAIL") }, 
		inverseJoinColumns = { @JoinColumn(name = "TEAM_NAME") })
	private List<Team> teams;
	
	public User()
	{
		
	}
	
	public User(@Email @NotEmpty String email, @NotEmpty String firstName, @NotEmpty String lastName, @Size(min = 6) String password) 
	{
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
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
	
	public List<Bug> getBugs() 
	{
		return bugs;
	}
	
	public void setBugs(List<Bug> bugs) 
	{
		this.bugs = bugs;
	}
	
	public List<Role> getRoles() 
	{
		return roles;
	}
	
	public void setRoles(List<Role> roles) 
	{
		this.roles = roles;
	}

	public List<Project> getProjects()
	{
		return projects;
	}
	
	public void setProjects(List<Project> projects) 
	{
		this.projects = projects;
	}
	
	public List<Team> getTeams() 
	{
		return teams;
	}

	public void setTeams(List<Team> teams) 
	{
		this.teams = teams;
	}

	public String getManagerEmail() 
	{
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) 
	{
		this.managerEmail = managerEmail;
	}
}
