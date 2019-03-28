package com.se.sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/seat")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class SeatsResource {


    @GET
    public Collection<String> getSeatList() {
        List<String> result = new ArrayList<>();

        result.add("1");
        result.add("2");
        result.add("3");
        result.add("4");
        result.add("5");

        return result;
    }
}
