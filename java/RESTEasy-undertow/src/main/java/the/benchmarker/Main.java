package the.benchmarker;

import javax.ws.rs.*;

@Path("/")
@Produces("text/plain")
public class Main {

    @GET
    @Path("/")
    @Produces("text/plain")
    public String get() {
        return "";
    }

    @GET
    @Path("/user/{id}")
    @Produces("text/plain")
    public String getUser(@PathParam("id") String id) {
        return id;
    }

    @POST
    @Path("/user")
    public String postUser() {
        return "";
    }

}
