package com.teofilmunteanu.BugTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Bug;

public interface BugRepository extends JpaRepository<Bug, Long>
{

}
