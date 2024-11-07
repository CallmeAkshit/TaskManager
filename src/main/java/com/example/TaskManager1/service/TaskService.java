package com.example.TaskManager1.service;


import java.util.List;

import com.example.TaskManager1.entity.Task;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Long taskId, Task taskDetails);
    List<Task> getTasksByUser(Long userId);
    Task markTaskAsCompleted(Long taskId);
    Task assignTask(Long taskId, Long userId);
    List<Task> filterTasksByStatus(Long userId, String status);
    List<Task> searchTasks(Long userId, String keyword);
}

