package com.noname.server.endpoint;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.exception.ResponseException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 04/02/16.
 */
@Component
@Path("/account")
public class AccountEndPoint {

    @Autowired
    private AccountService accountService;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(@Valid @NotNull CredentialIn credentialIn) {
        try {
            final CredentialOut account = accountService.createAccount(credentialIn);
            return Response.status(HttpStatus.CREATED.value()).entity(account).build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}