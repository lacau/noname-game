package com.noname.server.converter;

import com.noname.server.domain.entity.Credential;
import com.noname.server.json.CredentialOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class CredentialConverter {

    public CredentialOut convert(Credential credential) {
        CredentialOut credentialOut = new CredentialOut();
        credentialOut.setToken(credential.getToken());
        credentialOut.setId(credential.getCdId());
        return credentialOut;
    }
}
