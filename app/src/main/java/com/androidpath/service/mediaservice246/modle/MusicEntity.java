package com.androidpath.service.mediaservice246.modle;

import java.io.Serializable;

public class MusicEntity implements Serializable {

    private String name;
    private String path;


    public MusicEntity(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return "MusicEntity [name=" + name + ", path=" + path + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
