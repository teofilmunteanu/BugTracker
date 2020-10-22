package com.teofilmunteanu.BugTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BugTrackerApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(BugTrackerApplication.class, args);
	}
}
