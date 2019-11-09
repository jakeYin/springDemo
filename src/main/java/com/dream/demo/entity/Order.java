package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2019-11-09 21:40:38
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 527061837274491505L;
    
    private String id;
    
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}