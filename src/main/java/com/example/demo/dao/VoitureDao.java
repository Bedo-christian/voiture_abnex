package com.example.demo.dao;

import com.example.demo.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureDao extends JpaRepository<Voiture, Integer> {
}
