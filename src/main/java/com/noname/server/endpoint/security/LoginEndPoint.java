package com.noname.server.endpoint.security;

import javax.validation.Valid;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.noname.server.json.CredentialIn;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 04/02/16.
 */
@Component
@Path("/login")
public class LoginEndPoint {

    @POST
    @Path("/token")
    public Response byToken(@HeaderParam("auth_token") String authToken) {
        if(authToken == null)
            return Response.status(417).build();
        return Response.ok().build();
    }

    @POST
    @Path("/credential")
    public Response byCredential(@Valid CredentialIn credentialIn) {
        return Response.ok().build();
    }
}
