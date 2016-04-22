package com.noname.server.endpoint;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noname.server.exception.ResponseException;
import com.noname.server.json.DefaultErrorOut;
import com.noname.server.json.NPCOut;
import com.noname.server.service.NPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 28/01/16.
 */
@Component
@Path("/npc")
@Produces(MediaType.APPLICATION_JSON)
public class NPCEndPoint {

    @Autowired
    private NPCService npcService;

    @GET
    @Path("/list")
    public Response getNPC(@HeaderParam("auth_id") Long authId) {
        try {
            final List<NPCOut> npcs = npcService.listRandomNPC();
            return Response.ok().entity(npcs).build();
        } catch(ResponseException e) {
            return Response.status(e.getStatus().value()).entity(new DefaultErrorOut(e.getMessage())).build();
        }
    }
}