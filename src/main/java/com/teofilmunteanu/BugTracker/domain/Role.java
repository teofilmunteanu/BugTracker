package com.teofilmunteanu.BugTracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role 
{
	@Id
	private String name;
	
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<User> users;

	public Role() 
	{
		
	}

	public Role(String name) 
	{
		this.name = name;
	}

	public Role(String name, List<User> users) 
	{
		this.name = name;
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

	public List<User> getUsers() 
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}
}
