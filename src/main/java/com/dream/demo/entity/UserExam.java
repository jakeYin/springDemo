package com.dream.demo.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (UserExam)实体类
 *
 * @author makejava
 * @since 2019-10-05 15:24:20
 */
@Data
public class UserExam implements Serializable {
    private static final long serialVersionUID = 541371441224681982L;
    
    private String id;
    //用户ID
    private String userId;
    //试卷ID
    private String examId;
    //状态 1 未开始 2 进行中 3 已交卷
    private String state;


}