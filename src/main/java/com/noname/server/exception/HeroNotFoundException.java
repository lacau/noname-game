package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 15/02/16.
 */
public class HeroNotFoundException extends ResponseException {

    public HeroNotFoundException() {
        super("", HttpStatus.NOT_FOUND);
    }
}