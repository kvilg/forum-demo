package com.example.demo.servis;

import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.RepoRoom;
import com.example.demo.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userData;
    @Autowired
    private RepoRoom roomData;




    public List<User> getAll() {
        return  this.userData.findAll();
    }
    public User getByLogin(String login) {
        return this.userData.getByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }



    public void registration(String name, String login,String password) throws Exception {
        if(login == null || password == null){
            throw new NullPointerException();
        }
        User user = userData.findByLogin(login);
        if(user != null){
            throw new Exception("user is created");
        }
        User newUser = new User(name,login,password);
        userData.save(newUser);

    }

    public void subscribeRoom(Long idUser, Long idRoom) throws Exception {
        if(idUser == null || idRoom == null){
            throw new NullPointerException();
        }
        if(!userData.findById(idUser).isPresent()){
            throw new Exception("not found user");
        }
        if(!roomData.findById(idRoom).isPresent()){
            throw new Exception("not found room");
        }


        User user = userData.findById(idUser).get();

        Room room = roomData.findById(idRoom).get();

        System.out.print(user.getName());
        System.out.println(room.getName());

        Set<Room> rooms = user.getRoomsUser();

        Set<User> users = room.getUsersInRoom();

        for ( Room r : rooms ){
            if (Objects.equals(r.getId(), idUser)){
                throw new Exception("user is subscribe");
            }
        }

        for ( User u : users ){
            if (Objects.equals(u.getId(), idUser)){
                throw new Exception("user is subscribe");
            }
        }

        user.addRoom(room);

        room.addUser(user);

        userData.save(user);

        roomData.save(room);

    }

    public void addFriend(Long idUser, Long idFriend) throws Exception {
        if(idUser == null || idFriend == null){
            throw new NullPointerException();
        }
        if(!userData.findById(idUser).isPresent()){
            throw new Exception("not found user");
        }
        if(!userData.findById(idFriend).isPresent()){
            throw new Exception("not found user");
        }


        User user = userData.findById(idUser).get();

        User friend =  userData.findById(idFriend).get();



        Set<User> users = user.getFriend();


        for ( User u : users ){
            if (Objects.equals(u.getId(), idFriend)){
                throw new Exception("user is friend");
            }
        }

        Set<User> friends = friend.getFriend();


        for ( User u : users ){
            if (Objects.equals(u.getId(), idFriend)){
                throw new Exception("user is friend");
            }
        }

        for ( User f : friends ){
            if (Objects.equals(f.getId(), idUser)){
                throw new Exception("user is friend");
            }
        }


        user.addFriend(friend);


        userData.save(user);


    }





}
