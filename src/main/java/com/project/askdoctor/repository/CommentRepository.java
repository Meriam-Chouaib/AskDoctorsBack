package com.project.askdoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.askdoctor.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
}