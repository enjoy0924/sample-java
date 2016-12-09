package com.allere.sample.restful.server;


import com.allere.sample.restful.api.SampleApi;
import com.allere.sample.restful.config.RESTApplication;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by G_dragon on 2016/12/8.
 */
public class RestfulServer {

    public static void main(String[] argv){
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        RESTApplication config = new RESTApplication();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdownNow();
        }));

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
