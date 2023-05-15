package com.srini.circuit.controller;

import com.srini.circuit.service.AppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
@Slf4j
public class AppController {
    private final AppService appService ;


    @GetMapping("/get")
    public Mono<String> get(){
       return appService.get();

    }





}
