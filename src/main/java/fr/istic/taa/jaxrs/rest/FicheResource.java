package fr.istic.taa.jaxrs.rest;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDAO;
import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheResource {
	   FicheDAO dao = new FicheDAO();
	   
	   @GET
	   @Path("/rando")
	   public Fiche getNewFiche() {
		   return new Fiche("Fiche",new Date(120,11,25), null, null);
	   }
	   
	   
	   @PUT
	   @Path("/{ficheid}/adduser/{userid}")
	   public Response addUserToFiche(@PathParam("ficheid") Long ficheid, @PathParam("userid") Long userid) {
	        UserDAO us_dao = new UserDAO();
		   	Fiche fiche = dao.findOne(Long.valueOf(ficheid));
	        User user = us_dao.findOne(userid);
	        fiche.setUser(user);
	        dao.update(fiche);
	        return Response.status(200).entity(fiche).build();
	    }
	   
   @GET
   @Path("/{ficheid}")
   public Response getUserById(@PathParam("ficheid") Long ficheid) {
        Fiche fiche = dao.findOne(Long.valueOf(ficheid));
        return Response.status(200).entity(fiche).build();
    }

   @GET
   @Path("/all")
   public Response getAllFiche() {
       return Response.status(200).entity(dao.findAll()).build();
   }

   @POST
   @Path("/add")
   @Consumes("application/json")
   @Produces("text/html")
   public Response addFiche(Fiche fiche) {
       dao.save(fiche);
       return Response.ok().entity("SUCCESS").build();
   }

   @DELETE
   @Path("/delete/{ficheid}")
   public Response deleteFiche(@PathParam("ficheid") int ficheid) {

       dao.delete(dao.findOne(Long.valueOf(ficheid)));
       return Response.ok().entity("SUCCESS").build();
   }
}