package com.example.demo.model;

import javax.persistence.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MessageMessenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Long messengerId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_id")
    private User user;

    private String textMessage;

    private LocalDateTime dataTime;

    private Boolean readStatus;


    public MessageMessenger(String textMessage, User user) {
        this.user = user;
        this.textMessage = textMessage;
        this.dataTime = LocalDateTime.now();
        this.readStatus = false;
    }
}
