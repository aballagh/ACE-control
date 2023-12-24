package com.example.voiture.controller;

import com.example.voiture.entity.Voiture;
import com.example.voiture.model.VM;
import com.example.voiture.service.VoitureService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/car")
public class VoitureController {
    @Autowired
    VoitureService voitureService;
    @GetMapping
    List<VM> FindAll(){
        return voitureService.FindAll();
    }
    @GetMapping("/{id}")
    public VM FindById(@PathVariable Long id) throws Exception {
        return voitureService.findById(id);
    }
    @PostMapping
    public void addVoiture(@RequestBody Voiture v){
        voitureService.addVoiture(v);
    }
}
