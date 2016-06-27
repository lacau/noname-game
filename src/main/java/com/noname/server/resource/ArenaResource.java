package com.noname.server.resource;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.exception.ResponseException;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.service.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/arena")
@Produces(MediaType.APPLICATION_JSON)
public class ArenaResource {

    @Autowired
    private ArenaService arenaService;

    @POST
    @Path("/enter/{id}")
    public Response enter(@PathParam("id") Long heroId, @HeaderParam("auth_id") Long authId) {
        try {
            arenaService.enter(heroId, authId);
            return Response.ok().build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}