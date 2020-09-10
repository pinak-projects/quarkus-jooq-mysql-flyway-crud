package org.jooqDemo.constants;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage implements Serializable {

	private String message;
}
