package com.project.serviceCenter.controller;

import com.project.serviceCenter.data.LoginRequest;
import com.project.serviceCenter.data.User;
import com.project.serviceCenter.data.UserRepository;
import com.project.serviceCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userServie;

    // Login method
    @PostMapping("/users/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody LoginRequest loginRequest) {
        User user = userServie.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            return ResponseEntity.ok(Map.of("message","Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid credentials"));
        }
    }

    //SignUP method
    @PostMapping("/users/signup")
    public ResponseEntity<Map<String,String>> signup(@RequestBody User user){
        String result = userServie.signup(user);
        if(result.equals("SignUp successful")){
            return ResponseEntity.ok(Map.of("message", result));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",result));
        }
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userServie.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id){
        return userServie.getUserById(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user){
        return userServie.createUser(user);
    }

    @PutMapping(path = "/users")
    public User updateUser(@RequestBody User user){
        return userServie.updateUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUserById(@PathVariable int id){
        return userServie.deleteUserById(id);
    }

    // Used in UserProfile.js to fetch the logged-in user's details by email
    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userServie.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }







}

