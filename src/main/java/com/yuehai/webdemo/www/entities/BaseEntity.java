package com.yuehai.webdemo.www.entities;

/**
 * Created by 月海 2018/5/18
 */
public class BaseEntity {
    protected String message;
    protected int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
