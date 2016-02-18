package com.noname.server.security;

import com.noname.server.cache.CacheManager;
import com.noname.server.cache.CredentialCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 18/02/16.
 */
@Component
public class CredentialValidator {

    // mili * sec * hour * day
    private static final long TOKEN_LIVE = 1000 * 3600 * 24 * 7;

    @Autowired
    private CacheManager cacheManager;

    public boolean isCredentialValid(String authId, String authToken) {
        long id;
        try {
            id = Long.valueOf(authId);
        } catch(NumberFormatException e) {
            return false;
        }

        final CredentialCache credentialCache = cacheManager.retrieve(id);
        if(credentialCache == null || !credentialCache.token.equals(authToken))
            return false;

        return credentialCache.tokenDate < System.currentTimeMillis() + TOKEN_LIVE;
    }
}
