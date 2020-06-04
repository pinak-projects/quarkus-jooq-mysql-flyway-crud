package org.jooqDemo.exception.mapper;

import lombok.extern.slf4j.Slf4j;
import org.jooqDemo.constants.ResponseMessage;
import org.jooqDemo.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        log.error("NotFoundException", e);
        return Response.status(Status.NOT_FOUND).entity(new ResponseMessage(e.getMessage())).build();
    }
}
