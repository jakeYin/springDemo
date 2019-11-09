package com.dream.demo.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (UserQuestion)实体类
 *
 * @author makejava
 * @since 2019-10-05 14:56:10
 */
@Data
public class UserQuestion implements Serializable {
    private static final long serialVersionUID = 729338064718553494L;
    
    private String id;
    //用户ID
    private String userId;
    //试卷ID
    private String examId;
    //试卷题目ID
    private String examQuestionId;
    //作答
    private String answer;
    //正确 1 错误 0
    private String state;
    //描述
    private String description;
    //1 收藏 0 未收藏
    private String isFav;
    //题目ID
    private String questionId;


}