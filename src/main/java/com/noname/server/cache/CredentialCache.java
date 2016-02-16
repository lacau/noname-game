package com.noname.server.cache;

import java.io.Serializable;

/**
 * Created by lacau on 16/02/16.
 */
public class CredentialCache implements Serializable {

    private static final long serialVersionUID = 8169329844419624417L;

    public Long id;

    public String token;

    public Long tokenDate;
}