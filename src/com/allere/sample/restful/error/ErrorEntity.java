package com.allere.sample.restful.error;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by G_dragon on 2016/12/8.
 *
 */

@XmlRootElement//标识该资源可以被jersey转为json或者xml
public class ErrorEntity {
    private int resp_code;
    private String resp_msg;

    public ErrorEntity(int resp_code, String resp_msg) {
        this.resp_code = resp_code;
        this.resp_msg = resp_msg;
    }
    public ErrorEntity() {
    }

    public int getResp_code() {
        return resp_code;
    }

    public void setResp_code(int resp_code) {
        this.resp_code = resp_code;
    }

    public String getResp_msg() {
        return resp_msg;
    }

    public void setResp_msg(String resp_msg) {
        this.resp_msg = resp_msg;
    }
}
