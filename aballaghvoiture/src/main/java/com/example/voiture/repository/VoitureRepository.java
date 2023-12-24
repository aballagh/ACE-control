package com.example.voiture.repository;

import com.example.voiture.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Author Aballagh Nezar

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
