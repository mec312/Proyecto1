package com.project.client.dao.impl;

import com.project.client.internal.BaseModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.client.dao.ClientDao;
import com.project.client.model.Client;
import com.project.client.repository.ClientRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private ClientRepository repository;

	@Override
	public Flux<Client> findAllClient() {
		return Flux.fromIterable(repository.findAll());
	}

	@Override
	public Client addClient(String dni, String nombre, String apellido, int edad, BaseModel tipo) {
		Client cli = repository.save(Client.builder().dni(dni).nombre(nombre).apellido(apellido).edad(edad).tipo(tipo).build());
		return  cli;
	}

	@Override
	public Client findClientbyDni(String dni) {
		return repository.findByDni(dni);
	}

}
