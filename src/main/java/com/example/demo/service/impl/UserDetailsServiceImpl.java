package com.example.demo.service.impl;

import com.example.demo.bean.UserDetailsImpl;
import com.example.demo.dao.UserDao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
                User user = userDAO.findByUsernameOrEmail(username)
                    .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with Username : " + username)
                );
        return UserDetailsImpl.build(user);
    }

}
