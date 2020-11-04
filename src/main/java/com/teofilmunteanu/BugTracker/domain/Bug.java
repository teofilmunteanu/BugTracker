package com.teofilmunteanu.BugTracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Bug 
{
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String subject;
	
	@NotEmpty
	private String startDate;
	
	@NotEmpty
	private String priority;
	
	@Column(name = "status")
	private String status = "Open";
	
	@NotEmpty
	@Column(length = 3000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "USER_EMAIL")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_NAME")
	private Project project;
	
	public Bug() 
	{
		
	}
	
	public Bug(@NotEmpty String subject, @NotEmpty String startDate, @NotEmpty String priority,
			String status, @NotEmpty String description) 
	{
		this.subject = subject;
		this.startDate = startDate;
		this.priority = priority;
		this.status = status;
		this.description = description;
	}

	public Bug(@NotEmpty String subject, @NotEmpty String startDate, @NotEmpty String priority, 
			String status, @NotEmpty String description, User user) 
	{
		this.subject = subject;
		this.startDate = startDate;
		this.priority = priority;
		this.status = status;
		this.description = description;
		this.user = user;
	}
	
	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getPriority()
	{
		return priority;
	}

	public void setPriority(String priority) 
	{
		this.priority = priority;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
