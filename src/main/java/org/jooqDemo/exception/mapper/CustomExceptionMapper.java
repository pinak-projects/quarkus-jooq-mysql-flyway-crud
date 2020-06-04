package org.jooqDemo.exception.mapper;

import lombok.extern.slf4j.Slf4j;
import org.jooqDemo.constants.ResponseMessage;
import org.jooqDemo.exception.CustomException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException e) {
        log.error("CustomException", e);
        return Response.status(e.getHttpStatus()).entity(new ResponseMessage(e.getMessage())).build();
    }
}
