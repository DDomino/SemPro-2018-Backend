/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.CarFacade;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.ExecutionException;
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
      
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    CarFacade CF = new CarFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarResource
     */
    public CarResource() {
    
    }

    
    @GET
     @Produces(MediaType.APPLICATION_JSON)
    public String hej(){
    return "hej";
    }
    
    /**
     * Retrieves representation of an instance of rest.CarResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCarsSrax() throws ProtocolException, IOException, InterruptedException, ExecutionException {
        
        String jsonStr = CF.ScrapeCars().toString();
        
        return jsonStr;
    }

//    @GET
//    @Path("/jonas")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getCarsJonas() throws ProtocolException, IOException {
//        return CF.getAllCarsJonas();
//
//    }

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
