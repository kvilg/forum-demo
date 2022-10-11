package com.example.demo.servis;

import com.example.demo.model.Messenger;
import com.example.demo.model.User;
import com.example.demo.repo.RepoMessenger;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessengerService {

    @Autowired
    private RepoMessenger messengerData;
    @Autowired
    private UserRepo userData;


    public void createMessenger(Long friendId,Long userId ) throws Exception {
        if(!userData.findById(userId).isPresent()){
            throw new Exception("user is not defend");
        }
        if(!userData.findById(friendId).isPresent()){
            throw new Exception("user is not defend");
        }

        User user = userData.findById(userId).get();

        User friend = userData.findById(friendId).get();

        Messenger room = new Messenger(user,friend);

        Messenger newRoom = messengerData.save(room);

        user.addMessenger(newRoom);

        userData.save(user);
    }
}
