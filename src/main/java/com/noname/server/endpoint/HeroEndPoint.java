package com.noname.server.endpoint;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.json.HeroIn;
import com.noname.server.json.HeroOut;
import com.noname.server.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/hero")
@Produces(MediaType.APPLICATION_JSON)
public class HeroEndPoint {

    @Autowired
    private HeroService heroService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHero(@Valid @NotNull HeroIn heroIn, @HeaderParam("auth_id") Long authId) {
        try {
            final HeroOut heroOut = heroService.createHero(heroIn, authId);
            return Response.status(HttpStatus.CREATED.value()).entity(heroOut).build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getHeroById(@PathParam("id") Long cdId, @HeaderParam("auth_id") Long authId) {
        try {
            final HeroOut heroOut = heroService.findHeroById(cdId, authId);
            return Response.ok().entity(heroOut).build();
        } catch(HeroNotFoundException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @GET
    @Path("/name/{name}")
    public Response getHeroByName(@PathParam("name") String name) {
        try {
            final HeroOut heroOut = heroService.findHeroByName(name);
            return Response.ok().entity(heroOut).build();
        } catch(HeroNotFoundException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }

    @GET
    @Path("/list")
    public Response getHeroList(@HeaderParam("auth_id") Long authId) {
        final List<HeroOut> heros = heroService.listHero(authId);
        return Response.ok(heros).build();
    }
}