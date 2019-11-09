package com.dream.demo.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (UserQuestionLog)实体类
 *
 * @author makejava
 * @since 2019-10-05 15:12:06
 */
@Data
public class UserQuestionLog implements Serializable {
    private static final long serialVersionUID = -19456718366479179L;
    
    private String id;
    //用户ID
    private String userId;
    //作答
    private String answer;
    //状态
    private String state;
    //描述
    private String description;
    //题目ID
    private String questionId;


}