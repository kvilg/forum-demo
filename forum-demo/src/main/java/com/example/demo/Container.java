package com.example.demo;

import com.example.demo.servis.MessageService;
import com.example.demo.servis.MessengerService;
import com.example.demo.servis.RoomService;
import com.example.demo.servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class Container {

    @Autowired
    private RoomService serviceRoom;

    @Autowired
    private UserService serviceUser;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessengerService messengerService;










    @GetMapping("/serviceRoom")
    public String name() throws Exception {

        serviceRoom.createRoom("osdgsdfgsdfds", 15L);


        return "serviceRoom";
    }

    @GetMapping("/EnterToRoom")
    public String EnterToRoom() throws Exception {

        serviceRoom.EnterToRoom(18L, 17L);


        return "EnterToRoom";
    }




    @GetMapping("/subscribeRoom")
    public String namess() throws Exception {

        serviceUser.subscribeRoom(15L, 18L);


        return "subscribeRoom";
    }


    @GetMapping("/SendMessageInRoom")
    public String SendMessageInRoom() throws Exception {

        messageService.sendMessageInRoom(18L,15L,"eeeeeeeeeeeeeeeeeeeeeee");


        return "SendMessageInRoom";
    }

    @GetMapping("/MessengerService")
    public String MessengerService() throws Exception {

        messengerService.createMessenger(15L,17L);


        return "MessengerService";
    }

    @GetMapping("/addFriend")
    public String addFriend() throws Exception {

        serviceUser.addFriend(15L,17L);


        return "addFriend";
    }





    @GetMapping("/post")
    public String s() {


        return "addFriend";
    }




}
