package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 12/02/16.
 */
public class ResourceAlreadyExistsException extends ResponseException {

    public ResourceAlreadyExistsException() {
        super("error.resource.already.exists", HttpStatus.CONFLICT);
    }
}