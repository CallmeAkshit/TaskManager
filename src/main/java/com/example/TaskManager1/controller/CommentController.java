package com.example.TaskManager1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManager1.entity.Comment;
import com.example.TaskManager1.service.CommentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/task/{taskId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long taskId, @Valid @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.addComment(taskId, comment));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Comment>> getCommentsByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(commentService.getCommentsByTask(taskId));
    }
}

