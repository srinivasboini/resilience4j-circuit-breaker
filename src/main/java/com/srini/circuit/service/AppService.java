package com.srini.circuit.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The type App service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AppService {

    private final RestTemplate restTemplate ;


    /**
     * Get string.
     *
     * @return the string
     */
    @CircuitBreaker(name = "controllerA", fallbackMethod = "fallback")
    public String get(){

        //throw  new HttpServerErrorException(HttpStatus.BAD_GATEWAY, "remote exception")  ;
        return restTemplate.getForEntity("https://dummyHost:8080/api/v1/get", String.class).getBody() ;

    }

    private String  fallback(Throwable throwable){
        log.info("{}", throwable);

        log.info("falling back to alt");
        return "fallback" ;
    }

}
