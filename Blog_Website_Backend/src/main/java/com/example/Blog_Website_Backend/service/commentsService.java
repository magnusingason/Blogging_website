package com.example.Blog_Website_Backend.service;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.comments;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.repository.commentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentsService {
    private commentsRepository commentsRepository;

    @Autowired
    public commentsService(commentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public comments CreateComment(comments comment){
        return commentsRepository.save(comment);
    }

    public List<comments> getCommentsByPost(posts post){
        return commentsRepository.findByPost(post);
    }
}
