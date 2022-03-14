package com.project.client.internal;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class BaseModel {
	
	@Valid
	@NotNull
	private String code;
	
	@Nullable
	private String description;

}
