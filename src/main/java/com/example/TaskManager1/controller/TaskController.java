package com.example.TaskManager1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManager1.entity.Task;
import com.example.TaskManager1.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @Valid @RequestBody Task taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(taskId, taskDetails));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUser(userId));
    }

    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.markTaskAsCompleted(taskId));
    }

    @PutMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<Task> assignTask(@PathVariable Long taskId, @PathVariable Long userId) {
        return ResponseEntity.ok(taskService.assignTask(taskId, userId));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Task>> filterTasksByStatus(@RequestParam Long userId, @RequestParam String status) {
        return ResponseEntity.ok(taskService.filterTasksByStatus(userId, status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam Long userId, @RequestParam String keyword) {
        return ResponseEntity.ok(taskService.searchTasks(userId, keyword));
    }
}

