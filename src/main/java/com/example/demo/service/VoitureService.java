package com.example.demo.service;

import com.example.demo.bean.VoitureRequest;
import com.example.demo.entity.Voiture;

import java.util.List;

public interface VoitureService {

    void saveVoiture(VoitureRequest voiture);

    List<Voiture> voitureList();
}
