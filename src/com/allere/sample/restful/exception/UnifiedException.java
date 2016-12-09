package com.allere.sample.restful.exception;

import com.allere.sample.restful.error.ErrorCode;

/**
 * Created by G_dragon on 2016/12/8.
 */
public class UnifiedException extends Exception {
    private int code;
    private String message;

    /**
     * 构造异常类
     * @param code
     * @param message
     */
    public UnifiedException( int code,String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据枚举类构造异常结果
     * @param errorCode
     */
    public UnifiedException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}