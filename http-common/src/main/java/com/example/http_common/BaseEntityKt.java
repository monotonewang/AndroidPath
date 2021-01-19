package com.example.http_common;

public class BaseEntityKt<T> {


    private T data;

    private String message;
    private String code;
    private long timestamp;
    private int status = -1;

    ResultException exception;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultException getException() {
        return exception;
    }

    public void setException(ResultException exception) {
        this.exception = exception;
    }

    public long getTimestamp() {
        return timestamp * 1000;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public boolean isNetWorkSuccess() {
        return "200".equals(code) || status == 0;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}

