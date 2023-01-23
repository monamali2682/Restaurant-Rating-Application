package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;
//import com.example.demo.repositories.UserRepository;

public class UserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name){
        User user = new User(name);
        return userRepository.save(user);
    }
}
