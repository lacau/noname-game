package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 12/02/16.
 */
public class InvalidCredentialsException extends ResponseException {

    public InvalidCredentialsException() {
        super("", HttpStatus.BAD_REQUEST);
    }
}