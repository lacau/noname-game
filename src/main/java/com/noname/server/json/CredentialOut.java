package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 12/02/16.
 */
public class CredentialOut implements Serializable {

    private static final long serialVersionUID = -9055569841727742061L;

    private Long id;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
