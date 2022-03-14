package com.project.client.model;

import com.project.client.internal.BaseModel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private BaseModel tipo;
}
