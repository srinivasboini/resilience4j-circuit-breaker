package com.srini.circuit;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Resilience4jCircuitBreakerApplication {

	@Bean
	public RegistryEventConsumer<CircuitBreaker> myRegistryEventConsumer() {

		return new RegistryEventConsumer<CircuitBreaker>() {
			@Override
			public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
				entryAddedEvent.getAddedEntry().getEventPublisher().onEvent(event -> log.info(event.toString()));
			}

			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

			}

			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jCircuitBreakerApplication.class, args);
	}

}
