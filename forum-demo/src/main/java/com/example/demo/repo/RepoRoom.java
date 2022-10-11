package com.example.demo.repo;

import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRoom extends JpaRepository<Room,Long> {
}
