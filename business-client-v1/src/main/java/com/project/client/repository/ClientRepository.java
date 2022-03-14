package com.project.client.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.client.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	Client findByDni(String dni);
}
