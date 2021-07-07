package com.example.demo.bean;

import com.example.demo.entity.User;
import com.example.demo.entity.Voiture;
import java.util.Date;

public class CommentBean {
    private int id;
    private String description;
    private User user;
    private Date createdAt;
    private Voiture voiture;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", voiture=" + voiture +
                '}';
    }
}
