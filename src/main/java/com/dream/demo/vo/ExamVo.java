package com.dream.demo.vo;

import lombok.Data;

/**
 * (ExamVo)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Data
public class ExamVo {

    private String id;

    private String userId;

    private String userExamId;
    //名称
    private String title;
    //类型
    private String type;

    private String duration;

    private String countNum;

    private String finishNum;

    private String errorNum;

    private String rightNum;

    private String notAnswerNum;

    private String favNum;

    private String rate;
    //状态 1 未开始 2 进行中 3 已交卷
    private String state;


}