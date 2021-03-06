package com.noname.server.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class LoginFilter implements ContainerRequestFilter {

    @Autowired
    private CredentialValidator credentialValidator;

    @Override
    public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
        final String authId = requestContext.getHeaderString("auth_id");
        final String authToken = requestContext.getHeaderString("auth_token");
        //        if(authId == null || authToken == null)
        //            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        //
        //        if(!credentialValidator.isCredentialValid(authId, authToken))
        //            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }
}