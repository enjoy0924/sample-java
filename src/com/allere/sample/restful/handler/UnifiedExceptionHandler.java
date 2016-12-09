package com.allere.sample.restful.handler;

import com.allere.sample.restful.error.ErrorCode;
import com.allere.sample.restful.error.ErrorEntity;
import com.allere.sample.restful.exception.UnifiedException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by G_dragon on 2016/12/8.
 *
 */

@Provider
public class UnifiedExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        Response.ResponseBuilder ResponseBuilder;

        if (e instanceof UnifiedException){

            //截取自定义类型
            UnifiedException exp = (UnifiedException) e;
            ErrorEntity entity = new ErrorEntity(exp.getCode(),exp.getMessage());
            ResponseBuilder = Response.ok(entity, MediaType.APPLICATION_JSON);
        }else {
            ErrorEntity entity = new ErrorEntity(ErrorCode.OTHER_ERR.getCode(),e.getMessage());
            ResponseBuilder = Response.ok(entity, MediaType.APPLICATION_JSON);
        }
        System.out.println("执行自定义异常");
        return ResponseBuilder.build();
    }
}