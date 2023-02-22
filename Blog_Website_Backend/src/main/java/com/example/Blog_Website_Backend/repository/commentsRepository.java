package com.example.Blog_Website_Backend.repository;

import com.example.Blog_Website_Backend.model.comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentsRepository  extends JpaRepository<comments, Integer> {

}

