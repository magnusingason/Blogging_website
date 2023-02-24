package com.example.Blog_Website_Backend.controller;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.comments;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.service.authorsService;
import com.example.Blog_Website_Backend.service.commentsService;
import com.example.Blog_Website_Backend.service.postsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class commentsController {
    private commentsService commentsService;
    private authorsService authorsService;
    private postsService postsService;

    @Autowired
    public commentsController(commentsService commentsService, authorsService authorsService, postsService postsService){
        this.postsService = postsService;
        this.authorsService = authorsService;
        this.commentsService = commentsService;
    }

    // ENDPOINT FOR CREATING A COMMENT ON A POST
    @PostMapping("/api/blog/comment")
    public String commentPOST(@RequestBody String json) throws JSONException{
        try{
            //serialize string json
            JSONObject jsonObject = new JSONObject(json);

            //get data for comment
            String comment_text = jsonObject.getString("comment_text");
            long post_id = jsonObject.getLong("post");
            long author_id = jsonObject.getLong("author");
            authors author = authorsService.getAuthorByID(author_id);
            posts post = postsService.getPostByID(post_id);

            //creating comment
            comments comment = new comments(comment_text,post,author);
            commentsService.CreateComment(comment);

            return "Created comment";
        }catch (Exception e){
            System.out.println(e);
            return "something went wrong when creating post";
        }
    }

    // ENDPOINT FOR GETTING A PARTICULAR POST BY ID
    @GetMapping("/api/blog/{id}/comments")
    public List<comments> postByIDGET(@PathVariable(value="id") long id) throws JSONException{
        posts post = postsService.getPostByID(id);
        List<comments> comments = commentsService.getCommentsByPost(post);
        return comments;
    }

}
