package com.noname.server.exception;

import javax.ws.rs.core.Response;

/**
 * Created by lacau on 12/02/16.
 */
public class InvalidCredentialsException extends ResponseException {

    public InvalidCredentialsException() {
        super("", Response.Status.BAD_REQUEST);
    }
}