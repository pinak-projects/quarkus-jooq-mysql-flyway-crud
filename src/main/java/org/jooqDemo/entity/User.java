package org.jooqDemo.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@NotNull
	@Positive
	private int userId;
	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

}
