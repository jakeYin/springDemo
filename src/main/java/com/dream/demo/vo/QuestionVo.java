package com.dream.demo.vo;

import com.dream.demo.dic.DataDict;
import com.dream.demo.entity.QuestionOption;
import lombok.Data;

import java.util.List;

/**
 * (Question)Vo
 *
 * @author makejava
 * @since 2019-09-30 22:50:03
 */

@Data
public class QuestionVo{
    private String id;
    //试卷题目ID
    private String userQuestionId;

    private String examId;
    //题目
    private String title;
    //类型
    private String type;
    //类型str
    @DataDict(dict = "PMP",source = "123")
    private String typeStr;
    //正确答案
    private String answerRight;
    //解析
    private String parser;
    //选项
    private List<QuestionOption> options;
    //用户ID
    private String userId;

    private String questionId;
    //作答
    private String answer;
    //正确 1 错误 0
    private String state;
    //描述
    private String description;
    //1 收藏 0 未收藏
    private String isFav;
}