package com.example.demo.controller;

import com.example.demo.bean.CommentBean;
import com.example.demo.bean.CommentsRequest;
import com.example.demo.bean.VoitureRequest;
import com.example.demo.dao.VoitureDao;
import com.example.demo.entity.User;
import com.example.demo.entity.Voiture;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;
import com.example.demo.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class VoitureController {
    @Autowired
    VoitureService voitureService;

    @Autowired
    CommentService commentService;

    @Autowired
    VoitureDao voitureDao;

    @PostMapping("/ajout-voiture")
    public ResponseEntity<String> postVoiture(@RequestBody VoitureRequest voitureRequest){
        try{
            voitureService.saveVoiture(voitureRequest);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * save comment on voiture
     * @param commentsRequest
     * @return
     */
    @PostMapping("/ajout-commment")
    public ResponseEntity<String> postComment(@RequestBody CommentsRequest commentsRequest){
        try{
            commentService.saveComment(commentsRequest);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * get all list voiture
     * @return
     */
    @GetMapping("/voiture/list")
    public ResponseEntity<?> listVoiture(){
       try {
          List<Voiture> voitureList = voitureService.voitureList();
           return new ResponseEntity<>(voitureList, HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       }
    }

    @GetMapping("/voiture/coms-list/{voiture_id}")
    public ResponseEntity<?> listComsVoiture(@PathVariable int voiture_id){
        try {
            Voiture voiture = voitureDao.findById(voiture_id).get();
            List<CommentBean> commentBeanList = commentService.voitureListWithComms(voiture);
            return new ResponseEntity<>(commentBeanList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
