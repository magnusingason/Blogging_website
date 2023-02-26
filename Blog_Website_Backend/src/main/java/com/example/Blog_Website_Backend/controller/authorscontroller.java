package com.example.Blog_Website_Backend.controller;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.model.posts;
import com.example.Blog_Website_Backend.service.authorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class authorscontroller {
    private authorsService authorsService;

    @Autowired
    public authorscontroller(authorsService authorsService){
        this.authorsService = authorsService;
    }


    // ENDPOINT FOR CREATING USER
    @PostMapping("/api/signup")
    public authors createAuthor(@RequestBody String json) throws JSONException {
        try {
            //serialize string json
            JSONObject jsonObject = new JSONObject(json);

            //get values from json
            String first_name = jsonObject.getString("first_name");
            String last_name = jsonObject.getString("last_name");
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            String bio = jsonObject.getString("bio");

            // create author
            authors author = new authors(first_name, username, last_name, password, bio);
            authors author_created = authorsService.createAuthor(author);

            return author_created;
        } catch(Exception  e){
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/api/profile/{id}")
    public authors authorGET(@PathVariable(value="id") long id) throws JSONException {

        //finds author based on id
        authors author = authorsService.getAuthorByID(id);
        return author;
    }

    @PostMapping("/api/login")
    public authors loginAuthor(@RequestBody String json) throws JSONException{
        try{
            //serialize string json
            JSONObject jsonObject = new JSONObject(json);

            //get values from json
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");

            authors author = authorsService.login(username, password);
            if(author == null){
                authors wrong_author = new authors(username= "wrong");
                return wrong_author;
            }
            return author;


        }catch (Exception e){
            return null;
        }
    }

}
