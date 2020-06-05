package org.jooqDemo.entity;

import lombok.*;
import org.jooqDemo.constants.APIConstants;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

	@NotNull
	private Integer userId;
	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	@PostConstruct
	public String getFullName() {
		return new StringBuilder().append(firstName).append(APIConstants.BLANK_QUOTE).append(lastName).toString();
	}
}
