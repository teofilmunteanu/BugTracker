package com.teofilmunteanu.BugTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teofilmunteanu.BugTracker.domain.Team;
import com.teofilmunteanu.BugTracker.domain.TeamId;
import com.teofilmunteanu.BugTracker.repository.TeamRepository;

@Service
public class TeamService
{
	@Autowired
	private TeamRepository teamRepo;
	
	public void createTeam(Team team)
	{
		teamRepo.save(team);
	}
	
	/*Returns the teams with the given string in their name as a List*/
	public List<Team> findByName(String name)
	{
		return teamRepo.findByNameLike("%" + name + "%");
	}
	
	public boolean teamExists(String name, String manager) 
	{
		if(teamRepo.findById((new TeamId(name, manager))).isPresent())
			return true;
		else
			return false;
	}
}
