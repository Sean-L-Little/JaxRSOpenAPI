package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {
	   UserDAO dao = new UserDAO();
	
   @GET
   @Path("/{userid}")
   public Response getUserById(@PathParam("userid") Long userid) {
        User user = dao.findOne(Long.valueOf(userid));
        return Response.status(200).entity(user).build();
    }
   

   @GET
   @Path("/all")
   public Response getAllUser() {
       return Response.status(200).entity(dao.findAll()).build();
   }

   @POST
   @Path("/add")
   @Consumes("application/json")
   @Produces("text/html")
   public Response addUser(User user) {
       dao.save(user);
       return Response.ok().entity("SUCCESS").build();
   }

   @DELETE
   @Path("/delete/{userid}")
   public Response deleteTag(@PathParam("userid") int userid) {

       dao.delete(dao.findOne(Long.valueOf(userid)));
       return Response.ok().entity("SUCCESS").build();
   }
}