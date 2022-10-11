package com.example.demo.repo;

import com.example.demo.model.MessageRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoMessage extends JpaRepository<MessageRoom,Long> {
}
