package com.example.Blog_Website_Backend.repository;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface postsRepository extends JpaRepository<posts, Integer> {
    posts save(posts post);
    List<posts> findAll();
    posts findByid(long id);
    posts findByauthor(authors author);
}
