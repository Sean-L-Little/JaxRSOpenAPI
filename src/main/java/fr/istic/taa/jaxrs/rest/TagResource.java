package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TagDAO;
import fr.istic.taa.jaxrs.domain.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Path("/tag")
@Produces({"application/json", "application/xml"})
public class TagResource {
	   TagDAO dao = new TagDAO();
	
   @GET
   @Path("/{tagid}")
   @Operation(summary = "Get Tag by ID",
   tags = {"tag"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response getTagById(@PathParam("tagid") Long tagid) {
	   // TagDAO dao = new TagDAO();
        Tag tag = dao.findOne(Long.valueOf(tagid));
  //      return new Tag("roger");
        return Response.status(200).entity(tag).build();
    }

   @GET
   @Path("/all")
   @Operation(summary = "Get All Tags",
   tags = {"tag"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response getAllTag() {
	 //  TagDAO dao = new TagDAO();
       return Response.status(200).entity(dao.findAll()).build();
   }

   @POST
   @Path("/add")
   @Consumes("application/json")
   @Operation(summary = "Add Tag to DB",
   tags = {"tag"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response addTag(
		   @Parameter(description = "Tag to Add", required = true) Tag tag) {
	 //  TagDAO dao = new TagDAO();
       dao.update(tag);
       return Response.ok().entity("SUCCESS").build();
   }

   @DELETE
   @Path("/delete/{tagid}")
   @Operation(summary = "Remove Tag from DB",
   tags = {"tag"},
   responses = {
         @ApiResponse(responseCode = "405", description = "Invalid input")
   })
   public Response deleteTag(@PathParam("tagid") int tagid) {
	//  TagDAO dao = new TagDAO();
       dao.delete(dao.findOne(Long.valueOf(tagid)));
       return Response.ok().entity("SUCCESS").build();
   }
}