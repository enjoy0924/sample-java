package com.allere.sample.restful.config;

import com.allere.sample.restful.filter.http.PreRequestFilter;
import com.allere.sample.restful.filter.http.ResponseFilter;
import com.allere.sample.restful.interceptor.http.GzipInterceptor;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * Created by G_dragon on 2016/12/8.
 *
 */

public class RESTApplication extends ResourceConfig {
    public RESTApplication() {

        //加载日志包
//        register(LoggingFilter.class);

        //加载json转换器,没有此转换器，转换失败
        register(JacksonJsonProvider.class);
        register(PreRequestFilter.class);
        register(ResponseFilter.class);
        register(GzipInterceptor.class);
//        register(org.glassfish.jersey.server.validation.ValidationFeature.class);
//        register(org.glassfish.jersey.server.spring.SpringComponentProvider.class);
//        register(org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider.class);
//        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);

        packages("com.alr.sample.restful.api",
                "com.alr.sample.restful.handler");
    }
}