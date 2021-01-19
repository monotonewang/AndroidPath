package com.example.a2021basic.model;


/**
 * @desc: 网络请求返回的数据模板
 * @author：zg
 * @date:17/10/24
 * @time:下午1:34
 */
public class HttpModel<T> extends BaseEntity{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "HttpModel{" +
                "data=" + data +
                '}';
    }
}
