package com.example.voiture.service;

import com.example.voiture.entity.Client;
import com.example.voiture.entity.Voiture;
import com.example.voiture.model.VM;
import com.example.voiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;


@Service
public class VoitureService {
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    RestTemplate restTemplate;
    private final String URL="http://localhost:8888/SERVICE-CLIENT";
    public List<VM> FindAll(){
        List<Voiture> cars=voitureRepository.findAll();
        ResponseEntity<Client[]> response =restTemplate.getForEntity(this.URL+"/api/client",
                Client[].class);
        Client[] client=response.getBody();

        return cars.stream().map((Voiture v)->mapToCarResponse(v,client)).toList();
    }
    private VM mapToCarResponse(Voiture v,Client [] clients){
        Client foundClient= Arrays.stream(clients).filter(client->client.getId().equals(v.getClientId()))
                .findFirst().orElse(null);
        return VM.builder().id(v.getId()).brand(v.getMarque()).client(foundClient).matricule(v.getMatricule())
                .model(v.getModel()).build();
    }

    public VM findById(Long id) throws Exception {
        Voiture voiture = voitureRepository.findById(id).orElseThrow(() -> new Exception("ID voiture not found"));
        Client client = restTemplate.getForObject(this.URL + "/api/client" + voiture.getClientId(), Client.class);
        return VM.builder().id(voiture.getId()).brand(voiture.getMarque()).client(client).matricule(voiture.getMatricule())
                .model(voiture.getModel()).build();
    }
    public void addVoiture(Voiture v){
        voitureRepository.save(v);
    }
}
