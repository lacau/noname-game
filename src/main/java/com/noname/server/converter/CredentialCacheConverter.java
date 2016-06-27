package com.noname.server.converter;

import com.noname.server.cache.CredentialCache;
import com.noname.server.domain.entity.Credential;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 16/02/16.
 */
@Component
public class CredentialCacheConverter {

    public CredentialCache convert(Credential credential) {
        CredentialCache credentialCache = new CredentialCache();
        credentialCache.id = credential.getCdId();
        credentialCache.token = credential.getToken();
        credentialCache.tokenDate = credential.getTokenDate().getTime();

        return credentialCache;
    }
}
