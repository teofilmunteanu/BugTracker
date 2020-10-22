package com.teofilmunteanu.BugTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
