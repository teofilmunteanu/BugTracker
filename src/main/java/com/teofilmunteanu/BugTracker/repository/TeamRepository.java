package com.teofilmunteanu.BugTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Team;
import com.teofilmunteanu.BugTracker.domain.TeamId;

public interface TeamRepository extends JpaRepository<Team, TeamId>{

	List<Team> findByNameLike(String name);
	
}
