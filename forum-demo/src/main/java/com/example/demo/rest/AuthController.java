package com.example.demo.rest;


import com.example.demo.model.LoginUser;
import com.example.demo.model.UserOut;
import com.example.demo.security.JwtTokenUtil;
import com.solidfire.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import com.example.demo.servis.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private UserService service;


    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthUser(@RequestParam("user") String userInp, @RequestParam("password") String passwordInp){


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInp, passwordInp));

        com.example.demo.model.User user = service.getByLogin(userInp);

        String token = jwtTokenUtil.generateToken(user);



        return token;
    }



    @PostMapping(path = "/loginBy", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserByJWT(@RequestParam("token") String token) {
        String tokenRes = jwtTokenUtil.getUsernameFromToken(token);


        return tokenRes;
    }
/** для того что бы токен авторизировал нужен префикс Bearer {token}*/


    @PostMapping(path = "/reg", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String reg(@RequestBody String body) {

        System.out.println(body);



        return "ok";
    }

}
