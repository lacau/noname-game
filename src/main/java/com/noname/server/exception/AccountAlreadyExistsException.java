package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 12/02/16.
 */
public class AccountAlreadyExistsException extends ResponseException {

    public AccountAlreadyExistsException() {
        super("", HttpStatus.CONFLICT);
    }
}