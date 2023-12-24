package com.example.eurikaclient.controller;

import com.example.eurikaclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.eurikaclient.entity.Client;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public List<Client> FindAll(){
        return clientService.FindAll();
    }
    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return clientService.FindById(id);
    }
    @PostMapping
    public void save(@RequestBody Client c){
        clientService.save(c);
    }
}

