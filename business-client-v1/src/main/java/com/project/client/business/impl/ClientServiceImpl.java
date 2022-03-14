package com.project.client.business.impl;

import com.project.client.internal.BaseModel;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.client.business.ClientService;
import com.project.client.dao.ClientDao;
import com.project.client.model.Client;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
	
	private final ClientDao clientDao;

	@Override
	public Flux<Client> findAllClient() {
		return clientDao.findAllClient();
	}

	@Override
	public ResponseEntity<Mono<Client>> findClientbyDni(String dni) {
		return validaRespuesta(clientDao.findClientbyDni(dni));
	}

	@Override
	public ResponseEntity<Mono<Client>> addClient(String dni, String nombre, String apellido, int edad, BaseModel tipo){
		return validaRespuesta(clientDao.addClient(dni, nombre, apellido, edad, tipo));
	}

	private ResponseEntity<Mono<Client>> validaRespuesta(Client cli) {
		return (cli!=null)
				? ResponseEntity.ok(Mono.just(cli))
						: ResponseEntity.noContent().build();
	}

}
