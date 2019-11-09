package com.dream.demo.entity;

import java.io.Serializable;

/**
 * (ExamQuestion)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public class ExamQuestion implements Serializable {
    private static final long serialVersionUID = -69171525526875613L;
    
    private String id;
    //试卷ID
    private String examId;
    //题目ID
    private String questionId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

}