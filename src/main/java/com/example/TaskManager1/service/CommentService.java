package com.example.TaskManager1.service;

import java.util.List;

import com.example.TaskManager1.entity.Comment;

public interface CommentService {
    Comment addComment(Long taskId, Comment comment);
    List<Comment> getCommentsByTask(Long taskId);
}

