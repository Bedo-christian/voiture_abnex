package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {
    @Query(value="SELECT u FROM User u WHERE u.username=?1 or u.email=?1")
    Optional<User> findByUsernameOrEmail(String username);

    @Query(value="SELECT u FROM User u WHERE u.email=?1")
    List<User> findByExistUsernameOrEmail(String username);
}
