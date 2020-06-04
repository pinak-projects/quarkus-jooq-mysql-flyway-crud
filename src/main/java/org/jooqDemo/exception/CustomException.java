package org.jooqDemo.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.ws.rs.core.Response.Status;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private Status httpStatus;

}
