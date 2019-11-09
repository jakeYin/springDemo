package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (House)实体类
 *
 * @author makejava
 * @since 2019-11-09 22:07:08
 */
public class House implements Serializable {
    private static final long serialVersionUID = -39480439181130753L;
    
    private String id;
    
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}