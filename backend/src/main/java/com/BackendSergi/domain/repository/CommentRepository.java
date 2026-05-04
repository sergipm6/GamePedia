package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByEntityTypeAndEntityIdOrderByCreatedAtDesc(String entityType, Long entityId);

}
