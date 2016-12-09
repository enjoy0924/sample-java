package com.allere.sample.restful.api;

import com.allere.sample.restful.error.ErrorCode;
import com.allere.sample.restful.exception.UnifiedException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by G_dragon on 2016/12/8.
 */

@Path("api")
public class SampleApi {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("hi")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getIt(@FormParam("name") String name) {

        System.out.println("准备回复数据");
        Map<String, String> param = new HashMap<>();
        param.put("hi", name);

        return param;
    }

    @GET
    @Path("exception")
    @Produces(MediaType.APPLICATION_JSON)
    public String throwException() throws UnifiedException {

        throw new UnifiedException(ErrorCode.OTHER_ERR);
//        return "Got it!";
    }
}