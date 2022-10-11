package com.example.demo.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String login;

    private String password;

    @ManyToMany( mappedBy = "usersInRoom")
    private Set<Room> roomsUser;

    @ManyToMany( mappedBy = "userInMessenger")
    private Set<Messenger> messengersUser = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_friend",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<User> friendsUser = new HashSet<>();


    public User() {


    }


    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String ssss) {
        this.name = ssss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idUser) {
        this.id = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Room> getRoomsUser() {
        return roomsUser;
    }

    public void setRoomsUser(Set<Room> roomsUser) {
        this.roomsUser = roomsUser;
    }

    public void addRoom(Room room) {
        roomsUser.add(room);
    }


    public void addMessenger(Messenger messenger) {
        messengersUser.add(messenger);
    }

    public Set<User> getFriend() {
        return friendsUser;
    }

    public void addFriend(User friend) {
        friendsUser.add(friend);
    }

    public Set<Messenger> getMessengersUser() {
        return messengersUser;
    }

    public Set<User> getFriendsUser() {
        return friendsUser;
    }
}