package com.noname.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by lacau on 28/01/16.
 */
@Path("/test")
public class UserEndPoint {

    @GET
    public String test() {
        return "up and running!";
    }
}
