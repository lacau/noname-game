package com.noname.server.adapter;

import com.noname.server.entity.Credential;
import com.noname.server.json.CredentialOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class CredentialAdapter {

    public CredentialOut adapt(Credential credential) {
        CredentialOut credentialOut = new CredentialOut();
        credentialOut.setToken(credential.getToken());
        credentialOut.setId(credential.getCdId());
        return credentialOut;
    }
}
