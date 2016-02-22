package com.noname.server.endpoint;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.json.SkillOut;
import com.noname.server.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/skill")
@Produces(MediaType.APPLICATION_JSON)
public class SkillEndPoint {

    @Autowired
    private SkillService skillService;

    @GET
    @Path("/list")
    public Response getSkillList() {
        final List<SkillOut> skills = skillService.listSkill();
        return Response.ok(skills).build();
    }
}