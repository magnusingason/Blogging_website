package com.example.Blog_Website_Backend.repository;


import com.example.Blog_Website_Backend.model.authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorsRepository extends JpaRepository<authors, Integer> {
    authors save(authors author);
    authors findByusername(String Username);
    authors findByid(long id);
}
