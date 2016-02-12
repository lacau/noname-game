package com.noname.server.endpoint.security;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 04/02/16.
 */
@Component
@Path("/account")
public class AccountEndPoint {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(@Valid CredentialIn credentialIn) {
        return Response.ok(new CredentialOut()).build();
    }
}
