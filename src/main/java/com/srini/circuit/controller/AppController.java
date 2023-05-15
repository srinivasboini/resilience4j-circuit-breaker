package com.srini.circuit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {
    private final WebClient webClient ;


    @GetMapping("/get")
    public String get(){
       return webClient.get()
                .uri("https://dummyhost:8080/api/v1/get")
                .retrieve()
                .bodyToMono(String.class)
                .block() ;

    }




}
