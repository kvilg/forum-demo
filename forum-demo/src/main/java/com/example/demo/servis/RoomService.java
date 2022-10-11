package com.example.demo.servis;

import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.RepoRoom;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RepoRoom roomData;

    @Autowired
    private UserRepo userData;


    public void createRoom(String name,Long userId ) throws Exception {
        if(name == null ){
            throw new Exception("not found name");
        }
        if(!userData.findById(userId).isPresent()){
            throw new Exception("user is not defend");
        }

        User user = userData.findById(userId).get();


        Room room = new Room(name,user);

        Room newRoom = roomData.save(room);

        user.addRoom(newRoom);

        userData.save(user);
    }

    public void EnterToRoom(Long roomId,Long userId ) throws Exception {
        if(roomId == null ){
            throw new Exception("not found name");
        }
        if(!userData.findById(userId).isPresent()){
            throw new Exception("user is not defend");
        }

        User user = userData.findById(userId).get();

        Room room = roomData.findById(roomId).get();

        room.addUser(user);

        user.addRoom(room);

        userData.save(user);

        roomData.save(room);

    }





}
