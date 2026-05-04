package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Comment;
import com.BackendSergi.domain.repository.CommentRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getComments(String entityType, Long entityId){
        return commentRepository.findByEntityTypeAndEntityIdOrderByCreatedAtDesc(entityType,entityId);
    }
}
