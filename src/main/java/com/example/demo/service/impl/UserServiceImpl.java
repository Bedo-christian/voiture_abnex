package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public boolean findUserByUsername(String username) {
        List<User> user = userDao.findByExistUsernameOrEmail(username);
        if(user.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public User getUserConnected() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //check first if there is any logged user
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userDao.getUserByEmail(currentUserName);
            //find the user information from database by name

            return user;
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = userDao.findAll();
        return userList;
    }
}
