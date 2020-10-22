package com.teofilmunteanu.BugTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
