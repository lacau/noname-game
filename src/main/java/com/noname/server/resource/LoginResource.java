package com.noname.server.resource;

import javax.validation.Valid;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.noname.server.domain.entity.Credential;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 04/02/16.
 */
@Component
@Path("/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @POST
    @Path("/token")
    public Response byToken(@HeaderParam("auth_token") String authToken, @HeaderParam("auth_id") Long authId) {
        if(authToken == null || authId == null)
            return Response.status(HttpStatus.EXPECTATION_FAILED.value()).build();

        Credential credential = new Credential();
        credential.setCdId(authId);
        credential.setToken(authToken);

        try {
            loginService.doLoginByToken(credential);
            return Response.ok().build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @POST
    @Path("/credential")
    public Response byCredential(@Valid CredentialIn credentialIn) {
        try {
            final CredentialOut credentialOut = loginService.doLoginByCredential(credentialIn);
            return Response.ok().entity(credentialOut).build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout(@HeaderParam("auth_token") String authToken, @HeaderParam("auth_id") Long authId) {
        Credential credential = new Credential();
        credential.setCdId(authId);
        credential.setToken(authToken);

        try {
            loginService.doLogout(credential);
            return Response.ok().build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}