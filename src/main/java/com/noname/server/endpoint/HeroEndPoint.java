package com.noname.server.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.entity.Hero;
import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/hero")
@Produces(MediaType.APPLICATION_JSON)
public class HeroEndPoint {

    @Autowired
    private HeroService service;

    @GET
    @Path("/{id}")
    public Response getHeroById(@PathParam("id") Long cdId) {
        try {
            final Hero hero = service.findHeroById(cdId);
            return Response.ok().entity(hero).build();
        } catch(HeroNotFoundException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @GET
    @Path("/name/{name}")
    public Response getHeroByName(@PathParam("name") String name) {
        try {
            final Hero hero = service.findHeroByName(name);
            return Response.ok().entity(hero).build();
        } catch(HeroNotFoundException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}