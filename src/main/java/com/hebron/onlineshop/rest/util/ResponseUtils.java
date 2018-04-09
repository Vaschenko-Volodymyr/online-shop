package com.hebron.onlineshop.rest.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Utils for the responses.
 */
public class ResponseUtils {
    public static Response buildBadRequest(Object message) {
        return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
    }

    public static Response buildOkResponse(Object message) {
        return Response.ok(message, MediaType.APPLICATION_JSON).build();
    }
}
