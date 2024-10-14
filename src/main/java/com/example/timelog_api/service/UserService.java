package com.example.timelog_api.service;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean CreateUser(User user){
        if(user == null || user.getUsername() == null || user.getCardNumber() == null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
