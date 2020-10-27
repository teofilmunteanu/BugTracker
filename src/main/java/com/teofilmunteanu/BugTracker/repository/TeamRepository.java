package com.teofilmunteanu.BugTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Team;

public interface TeamRepository extends JpaRepository<Team, String>{

}
