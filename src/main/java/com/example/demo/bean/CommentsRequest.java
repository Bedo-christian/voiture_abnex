package com.example.demo.bean;

import com.example.demo.entity.User;
import com.example.demo.entity.Voiture;

import javax.persistence.*;
import java.util.Date;


public class CommentsRequest {
    private String description;
    private int voiture_id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVoiture_id() {
        return voiture_id;
    }

    public void setVoiture_id(int voiture_id) {
        this.voiture_id = voiture_id;
    }
}
