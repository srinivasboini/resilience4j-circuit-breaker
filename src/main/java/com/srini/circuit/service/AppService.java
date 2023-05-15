package com.srini.circuit.service;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppService {

    private final WebClient webClient ;

    private final CircuitBreakerRegistry circuitBreakerRegistry ;


    @CircuitBreaker(name = "controllerA", fallbackMethod = "fallback")
    public Mono<String> get(){

        //throw  new HttpServerErrorException(HttpStatus.BAD_GATEWAY, "remote exception")  ;
        return webClient.get()
                .uri("https://dummyhost:8080/api/v1/get")
                .retrieve()
                .bodyToMono(String.class);

    }

    private Mono<String> fallback(Throwable throwable){
        log.info("{}", throwable);

        log.info("falling back to alt");
        return Mono.just("fallback") ;
    }

}
