package com.teofilmunteanu.BugTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Bug;
import com.teofilmunteanu.BugTracker.domain.User;

public interface BugRepository extends JpaRepository<Bug, Long>{
	
	List<Bug> findByUser(User user);
	
}
