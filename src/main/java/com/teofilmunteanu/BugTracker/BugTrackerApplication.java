package com.teofilmunteanu.BugTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.service.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class BugTrackerApplication implements CommandLineRunner
{
	@Autowired
	private UserService userService;

	public static void main(String[] args) 
	{
		SpringApplication.run(BugTrackerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		User newManager = new User("manager@email.com", "Manager", "Test", "manager");
		newManager.setName(newManager.getFirstName() + ' ' + newManager.getLastName());
		newManager.setManagerEmail("manager@email.com");
		userService.createManager(newManager);
	}
}
