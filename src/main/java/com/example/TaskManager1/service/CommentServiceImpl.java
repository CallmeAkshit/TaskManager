package com.example.TaskManager1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager1.entity.Comment;
import com.example.TaskManager1.entity.Task;
import com.example.TaskManager1.repository.CommentRepository;
import com.example.TaskManager1.repository.TaskRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Comment addComment(Long taskId, Comment comment) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));

        comment.setTask(task);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByTask(Long taskId) {
        return commentRepository.findByTask_Id(taskId);
    }
}

