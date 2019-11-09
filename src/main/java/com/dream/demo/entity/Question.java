package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public class Question implements Serializable {
    private static final long serialVersionUID = -45105775430505186L;
    
    private String id;
    //题目
    private String title;
    //类型
    private String type;
    //正确答案
    private String answerRight;
    //解析
    private String parser;


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

    public String getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(String answerRight) {
        this.answerRight = answerRight;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

}