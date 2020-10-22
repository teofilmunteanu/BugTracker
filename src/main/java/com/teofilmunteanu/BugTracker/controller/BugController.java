package com.teofilmunteanu.BugTracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teofilmunteanu.BugTracker.domain.Bug;
import com.teofilmunteanu.BugTracker.exception.ResourceNotFoundException;
import com.teofilmunteanu.BugTracker.repository.BugRepository;

@RestController
@RequestMapping("/api")
public class BugController 
{

    @Autowired
    BugRepository bugRepository;

    // Get All Bugs
    @GetMapping("/bugs")
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }
    
    // Create a new Bug
    @PostMapping("/bugs")
    public Bug createBug(@Valid @RequestBody Bug bug) {
        return bugRepository.save(bug);
    }
    
    // Get a Single Bug
    @GetMapping("/bugs/{id}")
    public Bug getBugById(@PathVariable(value = "id") Long bugId) {
        return bugRepository.findById(bugId)
                .orElseThrow(() -> new ResourceNotFoundException("Bug", "id", bugId));
    }
    
    // Update a Bug
    @PutMapping("/bugs/{id}")
    public Bug updateBug(@PathVariable(value = "id") Long bugId,
                                            @Valid @RequestBody Bug bugDetails) {

    	Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new ResourceNotFoundException("Bug", "id", bugId));

    	bug.setTitle(bugDetails.getTitle());
    	bug.setContent(bugDetails.getContent());

        Bug updatedBug = bugRepository.save(bug);
        return updatedBug;
    }
    
    // Delete a Bug
    @DeleteMapping("/bugs/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long bugId) {
    	Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new ResourceNotFoundException("Bug", "id", bugId));

    	bugRepository.delete(bug);

        return ResponseEntity.ok().build();
    }
}