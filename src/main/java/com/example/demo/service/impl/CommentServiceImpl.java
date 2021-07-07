package com.example.demo.service.impl;

import com.example.demo.bean.CommentBean;
import com.example.demo.bean.CommentResponse;
import com.example.demo.bean.CommentsRequest;
import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.VoitureDao;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Voiture;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentsDao commentsDao;

    @Autowired
    VoitureDao voitureDao;

    @Override
    public List<CommentBean> voitureListWithComms(Voiture voiture) {
        List<Comments> commentsList = commentsDao.listComments(voiture);
        List<CommentBean> commentBeans = new ArrayList<>();

        for (Comments comments: commentsList){
            CommentBean commentBean = new CommentBean();
            commentBean.setId(comments.getId());
            commentBean.setDescription(comments.getDescription());
            commentBean.setCreatedAt(comments.getCreatedAt());
            commentBean.setUser(comments.getUser());
            commentBean.setVoiture(voiture);
            commentBeans.add(commentBean);
        }

        return commentBeans;
    }

    @Override
    public List<Comments> getallComment() {
        List<Comments> commentsList = commentsDao.findAll();
        return commentsList;
    }

    @Override
    public void saveComment(CommentsRequest commentsRequest) {
            Comments comments = new Comments();
            Voiture voiture = voitureDao.getOne(commentsRequest.getVoiture_id());
            comments.setCreatedAt(new Date());
            comments.setDescription(commentsRequest.getDescription());
            comments.setVoiture(voiture);

            commentsDao.save(comments);
    }
}
