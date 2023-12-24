package com.example.eurikaclient;

import com.example.eurikaclient.entity.Client;
import com.example.eurikaclient.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient


    public class EurikaclientApplication {

        public static void main(String[] args) {
            SpringApplication.run(EurikaclientApplication.class, args);
        }
        @Bean
        CommandLineRunner initialiserH2Database(ClientRepository clientRepository){
            return  args -> {
                clientRepository.save(new Client(Long.parseLong("1"),"Amine Safi",Float.parseFloat("23")));
                clientRepository.save(new Client(Long.parseLong("2"),"Amal Alaoui",Float.parseFloat("23")));
                clientRepository.save(new Client(Long.parseLong("3"),"Samir Rami",Float.parseFloat("22")));

            };
        }
    }
