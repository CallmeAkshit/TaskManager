package com.example.TaskManager1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManager1.entity.Project;
import com.example.TaskManager1.service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @PutMapping("/{projectId}/addUser/{userId}")
    public ResponseEntity<Project> addUserToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        return ResponseEntity.ok(projectService.addUserToProject(projectId, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.getProjectsByUser(userId));
    }
}

