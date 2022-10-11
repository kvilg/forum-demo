package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @ManyToMany
    @JoinTable(
            name = "user_room",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> usersInRoom = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "roomId")
    private Set<MessageRoom> messagesInRoom = new HashSet<>();

    public Room() {

    }
    public Room(String name, User  user) {
        this.name = name;
        this.usersInRoom.add(user);
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsersInRoom() {
        return usersInRoom;
    }

    public void setUsersInRoom(Set<User> usersInRoom) {
        this.usersInRoom = usersInRoom;
    }

    public void addUser(User user) {
        usersInRoom.add(user);
    }

    public void addMessage(MessageRoom message) {
        this.messagesInRoom.add(message);
    }
}
