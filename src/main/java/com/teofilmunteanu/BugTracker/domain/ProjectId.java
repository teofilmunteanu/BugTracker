package com.teofilmunteanu.BugTracker.domain;

import java.io.Serializable;

public class ProjectId implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String managerEmail;
	private String name;	
	
	public ProjectId() 
	{
		
	}
	
	public ProjectId(String name, String managerEmail) 
	{
		this.name = name;
		this.managerEmail = managerEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((managerEmail == null) ? 0 : managerEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectId other = (ProjectId) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (managerEmail == null) {
			if (other.managerEmail != null)
				return false;
		} else if (!managerEmail.equals(other.managerEmail))
			return false;
		return true;
	}	
}
