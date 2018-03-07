package apitesting.Resteasy;

import apitesting.Model.PostCodeResponse;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface PostCodes {

    @GET
    @Path("/ar/{postId}")
    PostCodeResponse get(@PathParam("postId") int postId);
}
