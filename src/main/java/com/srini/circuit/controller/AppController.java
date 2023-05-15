package com.srini.circuit.controller;

import com.srini.circuit.service.AppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type App controller.
 */
@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
@Slf4j
public class AppController {
    private final AppService appService ;


    /**
     * Get string.
     *
     * @return the string
     */
    @GetMapping("/get")
    public String get(){
       return appService.get();

    }





}
