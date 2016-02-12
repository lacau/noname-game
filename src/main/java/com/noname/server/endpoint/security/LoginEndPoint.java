package com.noname.server.endpoint.security;

import javax.validation.Valid;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.noname.server.entity.Credential;
import com.noname.server.exception.InvalidCredentialsException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 04/02/16.
 */
@Component
@Path("/login")
public class LoginEndPoint {

    @Autowired
    private LoginService loginService;

    @POST
    @Path("/token")
    public Response byToken(@HeaderParam("auth_token") String authToken, @HeaderParam("auth_id") Long authId) {
        if(authToken == null || authId == null)
            return Response.status(417).build();

        Credential credential = new Credential();
        credential.setCdId(authId);
        credential.setToken(authToken);

        try {
            final CredentialOut credentialOut = loginService.doLoginByToken(credential);
            return Response.ok().entity(credentialOut).build();
        } catch(InvalidCredentialsException e) {
            return Response.status(e.getStatus()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @POST
    @Path("/credential")
    public Response byCredential(@Valid CredentialIn credentialIn) {
        try {
            final CredentialOut credentialOut = loginService.doLoginByCredential(credentialIn);
            return Response.ok().entity(credentialOut).build();
        } catch(InvalidCredentialsException e) {
            return Response.status(e.getStatus()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}