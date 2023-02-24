package com.example.Blog_Website_Backend.service;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.repository.postsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postsService {
    private postsRepository postsRepository;

    @Autowired
    public postsService(postsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public posts createPost(posts post){
        return postsRepository.save(post);
    }

    public List<posts> getAllPosts(){
        return postsRepository.findAll();
    }

    public posts getPostByID(long id){
        return postsRepository.findByid(id);
    }

    public List<posts> getPostsByAuthor(authors author){
        return postsRepository.findByauthor(author);
    }
}
