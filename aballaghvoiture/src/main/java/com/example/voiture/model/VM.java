package com.example.voiture.model;

import com.example.voiture.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VM {
    private Long id;
    private String brand;
    private String model;
    private String matricule;
    private Client client;
}

