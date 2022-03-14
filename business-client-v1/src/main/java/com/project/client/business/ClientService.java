package com.project.client.business;

import com.project.client.internal.BaseModel;
import org.springframework.http.ResponseEntity;

import com.project.client.model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	Flux<Client> findAllClient();
	ResponseEntity<Mono<Client>> findClientbyDni(String dni);
	ResponseEntity<Mono<Client>> addClient(String dni, String nombre, String apellido, int edad, BaseModel tipo);
}
