package com.noname.server.endpoint.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

/**
 * Created by lacau on 12/02/16.
 */
public class LoginFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
        final String authId = requestContext.getHeaderString("auth_id");
        final String authToken = requestContext.getHeaderString("auth_token");
        if(authId == null || authToken == null)
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);

        // TODO: validate id/token
    }
}