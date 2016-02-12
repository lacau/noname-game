package com.noname.server.exception;

import javax.ws.rs.core.Response;

/**
 * Created by lacau on 12/02/16.
 */
public class ResponseException extends Exception {

    private Response.Status status;

    public ResponseException(String messageKey, Response.Status status) {
        super(messageKey);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
