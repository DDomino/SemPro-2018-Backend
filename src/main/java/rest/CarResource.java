/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import facade.CarFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Andreas
 */
@Path("car")
public class CarResource {

    @Context
    private UriInfo context;
    Gson gson = new Gson();
    CarFacade CF = new CarFacade();

    /**
     * Creates a new instance of CarResource
     */
    public CarResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CarResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars() {
        return gson.toJson(CF.getAllCars());

    }

    /**
     * PUT method for updating or creating an instance of CarResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content) {
    }
}
