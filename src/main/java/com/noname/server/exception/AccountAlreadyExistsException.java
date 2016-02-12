package com.noname.server.exception;

import javax.ws.rs.core.Response;

/**
 * Created by lacau on 12/02/16.
 */
public class AccountAlreadyExistsException extends ResponseException {

    public AccountAlreadyExistsException() {
        super("", Response.Status.CONFLICT);
    }
}
