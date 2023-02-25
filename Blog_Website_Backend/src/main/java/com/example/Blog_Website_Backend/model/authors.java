package com.example.Blog_Website_Backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
public class authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="author_id",
            updatable = false
    )
    private long id;
    @Column(
            name="first_name",
            nullable = false
    )
    private String first_name;

    public authors(String username) {
        this.username = username;
    }

    @Column(
            name="username",
            nullable = false,
            unique = true
    )
    private String username;
    @Column(
            name="last_name",
            nullable = false
    )
    private String last_name;
    @Column(
            name="password",
            nullable = false
    )
    private String password;
    @Column(
            name="bio",
            nullable = false,
            columnDefinition = "text"
    )
    private String bio;

    @OneToMany(mappedBy = "author",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    List<posts> posts = new ArrayList<>();


    @OneToMany(mappedBy = "author",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    List<comments> comments = new ArrayList<>();

    public authors(String first_name, String username, String last_name, String password, String bio, List<com.example.Blog_Website_Backend.model.posts> posts, List<com.example.Blog_Website_Backend.model.comments> comments) {
        this.first_name = first_name;
        this.username = username;
        this.last_name = last_name;
        this.password = password;
        this.bio = bio;
        this.posts = posts;
        this.comments = comments;
    }

    public authors() {
    }

    public long getAuthor_id() {
        return id;
    }

    public authors(String first_name, String username, String last_name, String password, String bio) {
        this.first_name = first_name;
        this.username = username;
        this.last_name = last_name;
        this.password = password;
        this.bio = bio;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<com.example.Blog_Website_Backend.model.posts> getPosts() {
        return posts;
    }

    public void setPosts(List<com.example.Blog_Website_Backend.model.posts> posts) {
        this.posts = posts;
    }

    public List<com.example.Blog_Website_Backend.model.comments> getComments() {
        return comments;
    }

    public void setComments(List<com.example.Blog_Website_Backend.model.comments> comments) {
        this.comments = comments;
    }
}
