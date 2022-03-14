package com.project.client.internal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientAddRequest {


	@Nullable
	private String id;

	@Valid
	@NotNull
	private String dni;

	@Valid
	@NotNull
	private String nombre;

	@Valid
	@NotNull
	private String apellido;

	@Nullable
	private int edad;

	@Nullable
	private BaseModel tipo;

}
