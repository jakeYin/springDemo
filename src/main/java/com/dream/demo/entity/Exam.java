package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (Exam)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public class Exam implements Serializable {
    private static final long serialVersionUID = 540897118039585732L;
    
    private String id;
    //名称
    private String title;
    //类型
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}