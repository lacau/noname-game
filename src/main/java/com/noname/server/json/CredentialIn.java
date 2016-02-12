package com.noname.server.json;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by lacau on 12/02/16.
 */
public class CredentialIn implements Serializable {

    private static final long serialVersionUID = 17923442677608326L;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
