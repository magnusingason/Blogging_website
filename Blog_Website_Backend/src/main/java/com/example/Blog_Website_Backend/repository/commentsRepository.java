package com.example.Blog_Website_Backend.repository;

import com.example.Blog_Website_Backend.model.comments;
import com.example.Blog_Website_Backend.model.posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface commentsRepository  extends JpaRepository<comments, Integer> {
    comments save(comments comment);
    List<comments> findByPost(posts post);
}

