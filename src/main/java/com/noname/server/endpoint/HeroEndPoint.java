package com.noname.server.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.noname.server.entity.Hero;
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
    public Hero getHeroById(@PathParam("id") Long cdId) {
        return service.findHeroById(cdId);
    }

    @GET
    @Path("/name/{name}")
    public Hero getHeroByName(@PathParam("name") String name) {
        return service.findHeroByName(name);
    }
}