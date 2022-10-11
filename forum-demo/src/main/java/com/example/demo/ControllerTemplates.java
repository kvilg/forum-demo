package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTemplates {

    @GetMapping("/")
    public String mainT()  {
        return "collect";
    }

    @GetMapping("/collect")
    public String collectT()  {
        return "collect";
    }
    @GetMapping("/friend")
    public String friend()  {
        return "friend";
    }
    @GetMapping("/home")
    public String homeT()  {
        return "home";
    }
    @GetMapping("/massage")
    public String massageT()  {
        return "massage";
    }
    @GetMapping("/massage-item")
    public String massageItemT()  {
        return "massage-item";
    }
    @GetMapping("/room")
    public String roomT()  {
        return "room";
    }
    @GetMapping("/registration")
    public String registrationT()  {
        return "registration";
    }
}
