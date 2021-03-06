package com.noname.server.resource;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.exception.ResponseException;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.json.SkillOut;
import com.noname.server.json.SkillSelectIn;
import com.noname.server.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/skill")
@Produces(MediaType.APPLICATION_JSON)
public class SkillResource {

    @Autowired
    private SkillService skillService;

    @GET
    @Path("/list")
    public Response getSkillList() {
        final List<SkillOut> skills = skillService.listSkill();
        return Response.ok(skills).build();
    }

    @POST
    @Path("/select")
    public Response selectSkills(@Valid @NotNull SkillSelectIn skillSelectIn, @HeaderParam("auth_id") Long authId) {
        try {
            skillService.selectSkills(skillSelectIn, authId);
            return Response.ok().build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}