package com.example.Blog_Website_Backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(
            name="comment_text"
    )
    private String comment_text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private posts post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private authors author;

    public long getID() {
        return ID;
    }

    public comments() {
    }

    public comments(String comment_text, posts post, authors author) {
        this.comment_text = comment_text;
        this.post = post;
        this.author = author;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public posts getPost() {
        return post;
    }

    public void setPost(posts post) {
        this.post = post;
    }

    public authors getAuthor() {
        return author;
    }

    public void setAuthor(authors author) {
        this.author = author;
    }
}
