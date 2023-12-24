package com.example.voiture.entity;

import jakarta.persistence.*;
import lombok.*;

//@Author Aballagh Nezar
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String model;
    private String matricule;
    @Column(name = "id_client")
    private Long clientId;
}



