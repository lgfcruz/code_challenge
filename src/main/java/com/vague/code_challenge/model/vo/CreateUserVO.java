package com.vague.code_challenge.model.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserVO implements Serializable {

	private static final long serialVersionUID = -6034711173488473085L;
	
	@NotNull(message = "validation.field.required.name")
	@Size(min = 3, message = "validation.length.min.name")
	private String name;

	@NotNull(message = "validation.field.required.role")
	@Size(min = 3, message = "validation.length.min.role")
	private String role;
	
	public CreateUserVO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
