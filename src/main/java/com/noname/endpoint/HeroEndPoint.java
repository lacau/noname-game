package com.noname.endpoint;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.noname.entity.*;
import com.noname.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

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
    public Hero get(@PathParam("id") Long cdId) {
        return service.findHero(cdId);
    }
}
