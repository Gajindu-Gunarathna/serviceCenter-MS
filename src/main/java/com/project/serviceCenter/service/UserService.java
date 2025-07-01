package com.project.serviceCenter.service;

import com.project.serviceCenter.data.User;
import com.project.serviceCenter.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    //Login
    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    //Sign Up
    public String signup(User user){
        User existingUser = userRepo.findByEmail(user.getEmail());
        if(existingUser != null){
            return "Email already exists";
        }
        userRepo.save(user);
        return "SignUp successful";
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(int id){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User deleteUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
            return user.get();
        } else {
            return null;
        }
    }



}
