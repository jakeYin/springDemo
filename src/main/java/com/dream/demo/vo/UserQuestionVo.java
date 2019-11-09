package com.dream.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * (UserExam)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Data
public class UserQuestionVo {

    // question id
    private String id;

    private String userQuestionId;
    //作答
    private String answer;

    private List<UserQuestionVo> answerList;

}