package com.example.voiture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//@Author Aballagh Nezar
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private Integer age;
}
