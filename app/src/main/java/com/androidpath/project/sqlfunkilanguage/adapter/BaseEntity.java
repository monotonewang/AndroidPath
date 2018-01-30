package com.androidpath.project.sqlfunkilanguage.adapter;

/**
 * Created by powyin on 2017/6/7.
 */

public class BaseEntity<T> {

    public int code;
    public String message;
    public T data;


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


    @Override
    public String toString() {
        return "BaseEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
