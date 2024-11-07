package com.example.TaskManager1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager1.entity.Task;
import com.example.TaskManager1.entity.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByAssignedTo_Id(Long userId);
    List<Task> findByAssignedTo_IdAndStatus(Long userId, TaskStatus status);
    List<Task> findByAssignedTo_IdAndTitleContainingOrDescriptionContaining(Long userId, String title, String description);

    
}

