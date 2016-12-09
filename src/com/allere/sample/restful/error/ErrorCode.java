package com.allere.sample.restful.error;

/**
 * Created by G_dragon on 2016/12/8.
 */
public enum ErrorCode {

    OK(0,"OK"),ID_INVALID(1,"ID is invalid"),OTHER_ERR(2,"未知错误");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}