package com.project.client.web;

import com.project.client.business.ClientService;
import com.project.client.internal.ClientAddRequest;
import com.project.client.model.Client;
import com.project.client.repository.ClientRepository;

import java.util.Optional;

import javax.validation.Valid;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@Log4j2
@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/findAll")
	public Flux<Client> findAllClient() {
		return service.findAllClient();
	}

	@Cacheable(value = "findbyDni", key = "#dni")
	@GetMapping(value = "/findbyDni")
	public ResponseEntity<Mono<Client>> findClientbyDni(
			@RequestParam(required = true) String dni) {
		return service.findClientbyDni(dni);
	}
	
	@GetMapping(value = "/findbyRuc")
	public Mono<String> findClientbyRuc(
			@RequestParam(required = true) String ruc) {
		return Mono.just("Prueba"+ruc);
	}
	
	@GetMapping(value = "/findbyType")
	public Flux<String> findClientbyType(
			@RequestParam(required = true) 
			String typeCode) {
		return Flux.just("Prueba"+typeCode);
	}

	@PostMapping(value = "/addClient")
	public HttpStatus addClient(@Valid @RequestBody ClientAddRequest request){
		service.addClient(request.getDni(), request.getNombre(), request.getApellido(), request.getEdad(), request.getTipo());
		try{
			log.info("ENTROOOOO > "+request.toString());
			return HttpStatus.CREATED;
		}catch(Exception er) {
			String erro = er.getMessage();
			log.info(erro);
			return HttpStatus.OK;
		}

	}

}
