package com.example.Blog_Website_Backend.controller;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.service.authorsService;
import com.example.Blog_Website_Backend.service.postsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class postsController {
    private postsService postsService;
    private com.example.Blog_Website_Backend.service.authorsService authorsService;

    @Autowired
    public postsController(postsService postsService, authorsService authorsService){
        this.postsService = postsService;
        this.authorsService = authorsService;
    }

    // ENDPOINT FOR CREATING A POST
    @PostMapping("/api/blog/post")
    public String postPOST(@RequestBody String json) throws JSONException{
        try{
            //serialize string json
            JSONObject jsonObject = new JSONObject(json);

            //get data for post
            String title = jsonObject.getString("title");
            String content = jsonObject.getString("content");
            long author_id = jsonObject.getLong("author");
            authors author = authorsService.getAuthorByID(author_id);

            //creating post
            posts post = new posts(title, content, author);
            postsService.createPost(post);

            return "created post!";
        }catch (Exception e){
            System.out.println(e);
            return "something went wrong when creating post";
        }
    }

    //ENDPOINT FOR GETTING ALL BLOG POSTS
    @GetMapping("/api/blog/post")
    public List<posts> allPostsGET() throws JSONException{
            //getting all posts
            List<posts> posts = postsService.getAllPosts();
            return posts;
    }

    // ENDPOINT FOR GETTING A PARTICULAR POST BY ID
    @GetMapping("/api/blog/{id}")
    public posts postByIDGET(@PathVariable(value="id") long id) throws JSONException{
        posts post = postsService.getPostByID(id);
        return post;
    }

    // ENDPOINT FOR GETTING A PARTICULAR POST BY USER
    @GetMapping("/api/blog/user/{id}")
    public List<posts> postsByAuthorsGET(@PathVariable(value="id") long id) throws JSONException{
        //first get the author
        authors author = authorsService.getAuthorByID(id);
        //then get the post and return it
        List<posts> post = postsService.getPostsByAuthor(author);

        return post;
    }

}
