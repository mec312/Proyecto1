package com.project.client.dao;

import com.project.client.internal.BaseModel;
import com.project.client.model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientDao {
	Flux<Client> findAllClient();
	Client addClient(String dni, String nombre, String apellido, int edad, BaseModel tipo);
	Client findClientbyDni(String dni);
}
