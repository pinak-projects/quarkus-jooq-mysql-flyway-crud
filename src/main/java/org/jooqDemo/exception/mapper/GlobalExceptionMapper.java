package org.jooqDemo.exception.mapper;

import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.constants.ResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        e.printStackTrace();
        System.out.println("here...");
        return Response.serverError().entity(new ResponseMessage(APIConstants.SOMETHING_WENT_WRONG)).build();
    }
}
