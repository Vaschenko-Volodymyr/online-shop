package com.hebron.onlineshop.rest.util;

import com.hebron.onlineshop.dto.ResponseDTO;

/**
 * Utils for the responses.
 */
public class ResponseUtils {
    public static ResponseDTO buildBadRequest(String message) {
        return new ResponseDTO()
                .setErrorMessage(message)
                .setResponseCode(400);
    }

    public static ResponseDTO buildOkResponse(String message) {
        return new ResponseDTO()
                .setInfo(message)
                .setResponseCode(200);
    }
}
