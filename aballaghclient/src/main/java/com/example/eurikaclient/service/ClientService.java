package com.example.eurikaclient.service;

import com.example.eurikaclient.entity.Client;

import com.example.eurikaclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> FindAll(){
        return clientRepository.findAll();
    }
    public Client FindById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(()->new  Exception("invalid client id"));
    }
    public void save(Client c){
        clientRepository.save(c);
    }

}

