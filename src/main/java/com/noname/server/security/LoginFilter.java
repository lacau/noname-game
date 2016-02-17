package com.noname.server.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import com.noname.server.cache.CacheManager;
import com.noname.server.cache.CredentialCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class LoginFilter implements ContainerRequestFilter {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
        final String authId = requestContext.getHeaderString("auth_id");
        final String authToken = requestContext.getHeaderString("auth_token");
        if(authId == null || authToken == null)
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);

        long id;
        try {
            id = Long.valueOf(authId);
        } catch(NumberFormatException e) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        final CredentialCache credentialCache = cacheManager.retrieve(id);
        if(credentialCache == null || !credentialCache.token.equals(authToken))
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }
}