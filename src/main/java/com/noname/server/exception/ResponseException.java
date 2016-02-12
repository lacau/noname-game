package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 12/02/16.
 */
public class ResponseException extends Exception {

    private HttpStatus status;

    public ResponseException(String messageKey, HttpStatus status) {
        super(messageKey);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
