package com.example.TaskManager1.service;



import java.util.List;

import com.example.TaskManager1.entity.Project;

public interface ProjectService {
    Project createProject(Project project);
    Project addUserToProject(Long projectId, Long userId);
    List<Project> getProjectsByUser(Long userId);
}

