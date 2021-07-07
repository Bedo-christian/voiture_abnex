package com.example.demo.dao;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsDao extends JpaRepository<Comments,Long> {

    @Query(value = "select c from Comments c where c.voiture = ?1 ")
    List<Comments> listComments(Voiture voiture);
}
