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
import fr.istic.taa.jaxrs.dao.generic.TagDAO;
import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheResource {
	   FicheDAO dao = new FicheDAO();
	   
	   @GET
	   @Path("/rando")
	   @Operation(summary = "Creates an new Card",
	   tags = {"fiche"},
	   responses = {
	         @ApiResponse(responseCode = "405", description = "Invalid input")
	   })
	   public Fiche getNewFiche() {
		   return new Fiche("Fiche",null, null, null);
	   }
	   
	   
	   @PUT
	   @Path("/{ficheid}/adduser/{userid}")
	   @Operation(summary = "Add User to Card by ID",
	   tags = {"fiche"},
	   description = "Adds a User to a Card",
	   responses = {
	           @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
	           @ApiResponse(responseCode = "404", description = "Card not found"),
	           @ApiResponse(responseCode = "405", description = "Validation exception")
	   })
	   public Response addUserToFiche(@PathParam("ficheid") Long ficheid, @PathParam("userid") Long userid) {
	        UserDAO us_dao = new UserDAO();
		   	Fiche fiche = dao.findOne(Long.valueOf(ficheid));
	        User user = us_dao.findOne(userid);
	        fiche.setUser(user);
	        dao.update(fiche);
	        return Response.status(200).entity(fiche).build();
	    }
	   
	   
	   
	   @PUT
	   @Path("/{ficheid}/addtag/{tagid}")
	   @Operation(summary = "Add Tag to Card by ID",
	   tags = {"fiche"},
	   description = "Adds a Tag to a Card",
	   responses = {
	           @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
	           @ApiResponse(responseCode = "404", description = "Card not found"),
	           @ApiResponse(responseCode = "405", description = "Validation exception")
	   })
	   public Response addTagToFiche(@PathParam("ficheid") Long ficheid, @PathParam("tagid") Long tagid) {
	        TagDAO tag_dao = new TagDAO();
		   	Fiche fiche = dao.findOne(Long.valueOf(ficheid));
	        Tag tag = tag_dao.findOne(tagid);
	        fiche.addTag(tag);
	        dao.update(fiche);
	        return Response.status(200).entity(fiche).build();
	    }
	   
	   
	   
	   
	   
   @GET
   @Path("/{ficheid}")
   @Operation(summary = "Find Card by ID",
   tags = {"fiche"},
   description = "Returns a Card with the given ID",
   responses = {
           @ApiResponse(description = "The Card", content = @Content(
                   schema = @Schema(implementation = Fiche.class)
           )),
           @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
           @ApiResponse(responseCode = "404", description = "Card not found"),
           @ApiResponse(responseCode = "405", description = "Validation exception")
   })
   public Response getFicheById(@PathParam("ficheid") Long ficheid) {
        Fiche fiche = dao.findOne(Long.valueOf(ficheid));
        return Response.status(200).entity(fiche).build();
    }

   
   
   
   
   @GET
   @Path("/all")
   @Operation(summary = "Get all Cards from the Board",
   tags = {"fiche"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response getAllFiche() {
       return Response.status(200).entity(dao.findAll()).build();
   }

   @POST
   @Path("/add")
   @Consumes("application/json")
   @Produces("text/html")
   @Operation(summary = "Add a new Card to the Board",
   tags = {"fiche"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response addFiche(
		   @Parameter(description = "Card to Add", required = true) Fiche fiche) {
	   
       dao.save(fiche);
       return Response.ok().entity("SUCCESS").build();
   }

   @DELETE
   @Path("/delete/{ficheid}")
   @Operation(summary = "Delete Card from the Board",
   tags = {"fiche"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response deleteFiche(@PathParam("ficheid") int ficheid) {

       dao.delete(dao.findOne(Long.valueOf(ficheid)));
       return Response.ok().entity("SUCCESS").build();
   }
}