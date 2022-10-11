package com.example.demo.servis;


import com.example.demo.model.MessageRoom;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.RepoMessage;
import com.example.demo.repo.RepoRoom;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private UserRepo userData;
    @Autowired
    private RepoRoom roomData;

    @Autowired
    private RepoMessage messageData;

    public void sendMessageInRoom(Long idRoom, Long idUser, String textMessage ) throws Exception {
        if(idRoom == null ){
            throw new Exception("name is null");
        }
        if(idUser == null ){
            throw new Exception("idUser is null");
        }
        if(textMessage == null ){
            throw new Exception("textMessage is null");
        }


        if(!userData.findById(idUser).isPresent()){
            throw new Exception("not found user");
        }
        if(!roomData.findById(idRoom).isPresent()){
            throw new Exception("not found room");
        }

        User user = userData.findById(idUser).get();

        Room room = roomData.findById(idRoom).get();

        MessageRoom message = new MessageRoom(textMessage,user);



        messageData.save(message);

        room.addMessage(message);

        roomData.save(room);



    }

}
