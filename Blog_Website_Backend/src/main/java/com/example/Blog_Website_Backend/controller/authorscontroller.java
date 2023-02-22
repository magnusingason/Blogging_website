package com.example.Blog_Website_Backend.controller;

import com.example.Blog_Website_Backend.model.authors;
import com.example.Blog_Website_Backend.service.authorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authorscontroller {
    private authorsService authorsService;

    @Autowired
    public authorscontroller(authorsService authorsService){
        this.authorsService = authorsService;
    }

    @PostMapping("/signup")
    public String createAuthor(@RequestBody String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String first_name = jsonObject.getString("first_name");
        String last_name = jsonObject.getString("last_name");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String bio = jsonObject.getString("bio");

        // Búa til nýtt booking
        authors author = new authors(first_name,username,last_name,password,bio);

        authorsService.createAuthor(author);
        return "ok!";
    }

}
