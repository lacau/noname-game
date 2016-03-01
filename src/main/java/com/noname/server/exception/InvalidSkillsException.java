package com.noname.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 01/03/16.
 */
public class InvalidSkillsException extends ResponseException {

    public InvalidSkillsException() {
        super("", HttpStatus.BAD_REQUEST);
    }
}