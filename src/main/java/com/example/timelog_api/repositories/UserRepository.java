package com.example.timelog_api.repositories;

import com.example.timelog_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, User> {
    User findUserByCardNumber(String cardNumber);
}
