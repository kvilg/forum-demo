package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MessageRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Long roomId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_id")
    private User user;

    private String textMessage;

    private LocalDateTime dataTime;


    public MessageRoom(String textMessage, User user) {
        this.user = user;
        this.textMessage = textMessage;
        this.dataTime = LocalDateTime.now();
    }
}
