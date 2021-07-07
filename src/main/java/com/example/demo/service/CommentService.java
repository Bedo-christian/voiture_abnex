package com.example.demo.service;

import com.example.demo.bean.CommentBean;
import com.example.demo.bean.CommentResponse;
import com.example.demo.bean.CommentsRequest;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Voiture;

import java.util.List;

public interface CommentService {

    List<CommentBean> voitureListWithComms(Voiture voiture);
    List<Comments> getallComment();
    void saveComment(CommentsRequest commentsRequest);
}
