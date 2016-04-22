package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 22/04/16.
 */
public class InternalServerErrorException extends ResponseException {

    public InternalServerErrorException() {
        super("error.internal.server.error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}