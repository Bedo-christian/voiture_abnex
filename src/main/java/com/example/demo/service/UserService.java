package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    boolean findUserByUsername(String username);
    User getUserConnected();
    List<User>findAllUser();
}
