package com.teofilmunteanu.BugTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teofilmunteanu.BugTracker.domain.Task;
import com.teofilmunteanu.BugTracker.domain.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByUser(User user);
}
