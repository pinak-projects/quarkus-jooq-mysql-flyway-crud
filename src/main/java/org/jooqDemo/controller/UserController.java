package org.jooqDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.constants.ResponseMessage;
import org.jooqDemo.entity.User;
import org.jooqDemo.exception.CustomException;
import org.jooqDemo.service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Slf4j
@Path(value = APIConstants.REST_USERS_END_POINT)
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(@Valid User user) {
        final int userId = userService.createUser(user);
        if (userId == 0) {
            log.info("ERROR: saveUser, MESSAGE: {}, ID: {}", APIConstants.ERROR_SAVE_USER, userId);
            throw new CustomException(APIConstants.ERROR_SAVE_USER, Status.NOT_IMPLEMENTED);
        }
        log.info("SUCCESS: saveUser, MESSAGE: {}, ID: {}", APIConstants.SUCCESS_SAVE_USER, userId);
        return Response.ok(new ResponseMessage(APIConstants.SUCCESS_SAVE_USER)).build();
    }

    @PUT
    @Path(value = APIConstants.USER_ID_PARAM)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam(APIConstants.USER_ID) final Integer userId, @Valid User user) {
        if (!userService.isUserExistsById(userId)) {
            log.info("ERROR: updateUser, MESSAGE: {}, ID: {}", APIConstants.ERROR_USER_NOT_FOUND, userId);
            throw new NotFoundException(APIConstants.ERROR_USER_NOT_FOUND);
        }
        user.setUserId(userId);
        final int affectedRows = userService.updateUserDetails(user);
        if (affectedRows < 1) {
            log.info("ERROR: updateUser, MESSAGE: {}, ID: {}", APIConstants.ERROR_UPDATE_USER, userId);
            throw new CustomException(APIConstants.ERROR_UPDATE_USER, Status.NOT_IMPLEMENTED);
        }
        log.info("SUCCESS: updateUser, MESSAGE: {}, ID: {}", APIConstants.SUCCESS_UPDATE_USER, userId);
        return Response.ok(new ResponseMessage(APIConstants.SUCCESS_UPDATE_USER)).build();
    }

    @GET
    @Path(value = APIConstants.USER_ID_PARAM)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam(value = APIConstants.USER_ID) final Integer userId) {
        log.info("getUser, ID: {}", userId);
        return userService.fetchUser(userId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        log.info("getAllUsers");
        return userService.fetchUsersList();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam(APIConstants.USER_ID) final Integer userId) {
        if (!userService.isUserExistsById(userId)) {
            log.info("ERROR: deleteUser, MESSAGE: {}, ID: {}", APIConstants.ERROR_USER_NOT_FOUND, userId);
            throw new NotFoundException(APIConstants.ERROR_USER_NOT_FOUND);
        }
        if (userService.deleteUser(userId) < 1) {
            log.info("ERROR: deleteUser, MESSAGE: {}, ID: {}", APIConstants.ERROR_DELETE_USER, userId);
            throw new CustomException(APIConstants.ERROR_DELETE_USER, Status.NOT_IMPLEMENTED);
        }
        log.info("SUCCESS: deleteUser, MESSAGE: {}, ID: {}", APIConstants.SUCCESS_USER_DELETED, userId);
        return Response.ok(new ResponseMessage(APIConstants.SUCCESS_USER_DELETED)).build();
    }

 }
