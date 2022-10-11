package com.example.demo.rest;

import com.example.demo.model.UserReg;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.servis.UserService;
import com.solidfire.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
public class RegistrationController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/registration/user")
    public String registrationUser(@RequestHeader Map<String, String> headers) throws Exception {
//        System.out.println(json);
//
//
//        Gson gson = new Gson();
//        UserReg user = gson.fromJson(json, UserReg.class);

        System.out.println(headers.get("login"));
        System.out.println(headers.get("username"));
        System.out.println(headers.get("password"));

        String username = headers.get("login");
        String login = headers.get("username");
        String password = headers.get("password");


        if (username == null || login == null || password == null ){
            throw new Exception("null username or login or password");
        }
        if (username.length() < 6){
            throw new Exception("user length < 6");
        }
        if (login.length() < 6){
            throw new Exception("login length < 6");
        }
        if (password.length() < 6){
            throw new Exception("password length < 6");
        }

        service.registration(username,login,password);


        com.example.demo.model.User user = service.getByLogin(login);


        return jwtTokenUtil.generateToken(user);
    }
}
