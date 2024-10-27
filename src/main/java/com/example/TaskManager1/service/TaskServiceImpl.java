package com.example.TaskManager1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager1.entity.Task;
import com.example.TaskManager1.entity.TaskStatus;
import com.example.TaskManager1.entity.User;
import com.example.TaskManager1.repository.TaskRepository;
import com.example.TaskManager1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setStatus(taskDetails.getStatus());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByAssignedTo_Id(userId);
    }

    @Override
    public Task markTaskAsCompleted(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));

        task.setStatus(TaskStatus.COMPLETED);

        return taskRepository.save(task);
    }

    @Override
    public Task assignTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        task.setAssignedTo(user);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> filterTasksByStatus(Long userId, String status) {
        TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
        return taskRepository.findByAssignedTo_IdAndStatus(userId, taskStatus);
    }

    @Override
    public List<Task> searchTasks(Long userId, String keyword) {
        return taskRepository.findByAssignedTo_IdAndTitleContainingOrDescriptionContaining(userId, keyword, keyword);
    }
}
