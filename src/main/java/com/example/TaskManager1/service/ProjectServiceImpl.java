package com.example.TaskManager1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager1.entity.Project;
import com.example.TaskManager1.entity.User;
import com.example.TaskManager1.repository.ProjectRepository;
import com.example.TaskManager1.repository.UserRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project addUserToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + projectId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        project.getMembers().add(user);
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getProjectsByUser(Long userId) {
        return projectRepository.findByMembers_Id(userId);
    }
}

