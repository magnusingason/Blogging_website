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

    // this function checks if the user with this username exists.
    // then it checks if this username fits with the password
    public authors login(String username, String password){
        authors author = authorsRepository.findByusername(username);
        if(author == null){
            return null;
        }else if(author.getPassword().equals(password)){
            return author;
        }
        return null;
    }
}
