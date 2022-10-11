package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenRepository;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.servis.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserService service;



    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/user/info")
    public String userInfo(@RequestHeader Map<String, String> headers) {


        String token = headers.get("Authorization");
        System.out.println(token);
        String user = jwtTokenUtil.getUsernameFromToken(token);



        return user;
    }



}
