package edu.upc.backend.services;

import edu.upc.backend.TeamDAO;
import edu.upc.backend.models.Team;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/", description = "Endpoint to Text Service")
@Path("/")
public class TextService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    Logger log = Logger.getLogger(TextService.class);

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @ApiOperation(value = "Get team by id", notes = "Hola k ase")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Team.class),
            @ApiResponse(code = 404, message = "User not found", response = Team.class)
    })
    @Path("/team/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeam(@PathParam("id") String id)
    {
        log.info("Trying to find team with id " + id);
        TeamDAO _teams = TeamDAO.getInstance();
        try {
            Team res = _teams.find(Integer.parseInt(id));
            return Response.status(201).entity(res).build();
        }
        catch (Exception e) { Response.status((404)).entity(e.getMessage()).build(); }
        return Response.status((404)).build();
    }

    @GET
    @ApiOperation(value = "Get team by team Name", notes = "Hola k ase")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Team.class),
            @ApiResponse(code = 404, message = "User not found", response = Team.class)
    })
    @Path("/user/{teamName}/team")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeamByTeamName(@PathParam("teamName") String teamName)
    {
        log.info("Trying to find team with name " + teamName);
        TeamDAO _teams = TeamDAO.getInstance();
        try {
            Team res = _teams.find(teamName);
            return Response.status(201).entity(res).build();
        }
        catch (Exception e) { Response.status((404)).entity(e.getMessage()).build(); }
        return Response.status((404)).build();
    }

    @Path("exception")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String throwIt() throws Exception {
        throw new Exception("My Exception");
    }




}
