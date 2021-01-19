package com.example.a2021basic.model;

/**
 * @author zg
 * @Desc: 实体bean基类
 * @Time:
 */
public class BaseEntity {

    private String message;
    private String code;
    private long timestamp;
    private int status = -1;

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
