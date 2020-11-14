package com.teofilmunteanu.BugTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teofilmunteanu.BugTracker.domain.Role;
import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	/*Encrypts the given password, assigns the "DEVELOPER" role and stores the user data in the database*/
	public void createDeveloper(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setName(user.getFirstName() + ' ' + user.getLastName());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setManagerEmail(user.getEmail());
		Role userRole = new Role("DEVELOPER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepo.save(user);
	}
	
	/*Encrypts the given password, assigns the "MANAGER" role and stores the user data in the database*/
	public void createManager(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setName(user.getFirstName() + ' ' + user.getLastName());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setManagerEmail(user.getEmail());
		Role userRole = new Role("PROJECT_MANAGER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepo.save(user);
	}
	
	/*Returns the User object related to the given email*/
	public User findOne(String email) 
	{
		if(userRepo.findById(email).isPresent())
			return userRepo.findById(email).get();
		else 
			return null;
	}
	
	/*Return all users as a List*/
	public List<User> findAll()
	{
		return userRepo.findAll();
	}
	
	/*Returns the users with the given string in their name as a List*/
	public List<User> findByName(String name)
	{
		return userRepo.findByNameLike("%" + name + "%");
	}
	
	/*Returns true if the given email is stored in the database and false otherwise*/
	public boolean userExists(String email) 
	{
		if(userRepo.findById(email).isPresent())
			return true;
		else
			return false;
	}
}
