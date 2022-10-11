package com.example.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

public class UserOut {

    private Long id;

    private String name;

    private String login;


    private Set<Long> roomsUser = new HashSet<>();


    private Set<Long> messengersUser = new HashSet<>();


    private Set<Long> friendsUser = new HashSet<>();

    public UserOut(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();



        for (Room r: user.getRoomsUser()) {
            roomsUser.add(r.getId());
        }

        for (User u: user.getFriendsUser()) {
            friendsUser.add(u.getId());
        }

        for (Messenger m: user.getMessengersUser()) {
            messengersUser.add(m.getId());
        }

    }

}
