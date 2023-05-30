package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public User registerUser(String phoneNumber) {
        User existingUser = userRepository.findByPhoneNumber(phoneNumber);
        if (existingUser != null) {
            throw new RuntimeException("User already exists.");
        }
        
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        
        return userRepository.save(user);
    }

    public User validateUser(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user == null) {
            throw new RuntimeException("Invalid user credentials.");
        }
        return user;
    }


}