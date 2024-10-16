package com.example.timelog_api.service;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String cardNumber) {
        return userRepository.findUserByCardNumber(cardNumber);
    }
}
