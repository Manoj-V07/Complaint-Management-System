package com.example.cms.service;

import com.example.cms.entity.User;
import com.example.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return "Email Already Registered!";
        }
        userRepository.save(user);
        return "User Registered Successfully!";
    }

    public String loginUser(String email,String password){
        Optional<User> existingUser = userRepository.findByEmail(email);

        if(existingUser.isPresent()){
            User user = existingUser.get();
            if(user.getPassword().equals(password)){
                return "Login Successfull as " + user.getRole();
            }else{
                return "Invalid Password!";
            }
        }else{
            return "User Not Found!";
        }
    }

    public Optional<User> getuserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
