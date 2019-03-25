/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_8_web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author mathiasjepsen
 */
@Path("pizza")
public class PizzaResource {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static OrderQueue orderQueue = new OrderQueue();

//    private static List<Quote> quotes = new ArrayList() {
//        {
//            add(new Quote(1, "Quote 1"));
//            add(new Quote(2, "Quote 2"));
//            add(new Quote(3, "Quote 3"));
//        }
//    };
//    private static int newId = 4;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteResource
     */
    public PizzaResource() {
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(String o) {
        Order order = gson.fromJson(o, Order.class);
        orderQueue.addOrder(order);
        return Response.status(200).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrders() {
        return gson.toJson(orderQueue);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeOrder() {
        int response = orderQueue.deleteOrder();
        if (response == 1) {
            return Response.ok().build();
        } else {
            throw new NotFoundException();
        }
    }
}
