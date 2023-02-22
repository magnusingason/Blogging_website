package com.example.Blog_Website_Backend.service;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.repository.authorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class authorsService {
    private authorsRepository authorsRepository;

    @Autowired
    public authorsService(authorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public authors createAuthor(authors author){
        return authorsRepository.save(author);
    }

    public authors getAuthorByID(long id){
        return authorsRepository.findByid(id);
    }

    public authors getAuthorByusername(String username){
        return authorsRepository.findByusername(username);
    }
}
