package com.example.demo.service.domain;

import java.io.Serializable;

public class ResultEntry<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int code;

    private String message;

    private T module;

    private boolean success;
    
    
    public static <T> ResultEntry<T> buildSuccess(T module) {
        ResultEntry<T> resultDO = new ResultEntry<T>();
        resultDO.setSuccess(true);
        resultDO.setModule(module);
        resultDO.setCode(1);
        return resultDO;
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


    public T getModule() {
        return module;
    }


    public void setModule(T module) {
        this.module = module;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

}
