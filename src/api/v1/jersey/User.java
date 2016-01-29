package api.v1.jersey;

/**
 * Created by timur on 29.01.16.
 */
        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;

@Path("/user")
public class User {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName(@PathParam("name") String name) {
        return name != null ? name : "No name";
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "template /user/Timur";
    }

}