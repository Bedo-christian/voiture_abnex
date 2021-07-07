package com.example.demo.bean;

import com.example.demo.entity.Voiture;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VoitureRequest {

    private int id;
    private String name;
    private String description;
    private Double price;

    public VoitureRequest(){}

    public VoitureRequest(Voiture voiture) {
        this.id = voiture.getId();
        this.setName(voiture.getName());
        this.setDescription(voiture.getDescription());
        this.setPrice(voiture.getPrice());
    }

    public  VoitureRequest getVoitureBean(Voiture voiture){return  new VoitureRequest(voiture);}

    public Voiture getVoitureEntity(){
        Voiture voiture = new Voiture();
        voiture.setId(this.id);
        voiture.setName(this.name);
        voiture.setDescription(this.name);
        voiture.setPrice(this.price);

        return voiture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
