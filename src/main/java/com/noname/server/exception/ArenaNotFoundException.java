package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 08/05/16.
 */
public class ArenaNotFoundException extends ResponseException {

    public ArenaNotFoundException() {
        super("error.arena.not.found", HttpStatus.NOT_FOUND);
    }
}