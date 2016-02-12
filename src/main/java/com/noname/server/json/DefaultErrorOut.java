package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 12/02/16.
 */
public class DefaultErrorOut implements Serializable {

    private static final long serialVersionUID = -3969390558352591935L;

    private String errorMessage;

    public DefaultErrorOut(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}