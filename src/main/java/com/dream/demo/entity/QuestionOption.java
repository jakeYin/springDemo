package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (QuestionOption)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public class QuestionOption implements Serializable {
    private static final long serialVersionUID = -73665325149178098L;
    
    private String id;
    //题目ID
    private String questionId;
    //描述
    private String description;
    //排序
    private String selection;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

}