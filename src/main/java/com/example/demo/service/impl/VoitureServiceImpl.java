package com.example.demo.service.impl;

import com.example.demo.bean.VoitureRequest;
import com.example.demo.dao.VoitureDao;
import com.example.demo.entity.Voiture;
import com.example.demo.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {
    @Autowired
    VoitureDao voitureDao;


    @Override
    public void saveVoiture(VoitureRequest voiture) {
        voitureDao.save(voiture.getVoitureEntity());
    }

    @Override
    public List<Voiture> voitureList() {
        return null;
    }

}
