package com.example.Blog_Website_Backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name= "post_id",
            updatable = false
    )
    private long id;
    @Column(
            name="title",
            nullable = false
    )
    private String title;
    @Column(
            name="content",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;

    @OneToMany(mappedBy = "post",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<comments> comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private authors author;

    public posts(String title, String content, List<com.example.Blog_Website_Backend.model.comments> comments, authors author) {
        this.title = title;
        this.content = content;
        this.comments = comments;
        this.author = author;
    }

    public posts() {
    }

    public posts(String title, String content, authors author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public long getid() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<com.example.Blog_Website_Backend.model.comments> getComments() {
        return comments;
    }

    public void setComments(List<com.example.Blog_Website_Backend.model.comments> comments) {
        this.comments = comments;
    }

    public authors getAuthor() {
        return author;
    }

    public void setAuthor(authors author) {
        this.author = author;
    }
}
