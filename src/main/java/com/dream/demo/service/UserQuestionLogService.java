package com.dream.demo.service;

import com.dream.demo.entity.UserQuestionLog;
import com.dream.demo.vo.QuestionSummaryVo;

import java.util.List;

/**
 * (UserQuestionLog)表服务接口
 *
 * @author makejava
 * @since 2019-10-05 15:12:06
 */
public interface UserQuestionLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserQuestionLog queryById(String id);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param userQuestionLog 实例对象
     * @return 对象列表
     */
    List<UserQuestionLog> queryAll(UserQuestionLog userQuestionLog);

    /**
     * 新增数据
     *
     * @param userQuestionLog 实例对象
     * @return 实例对象
     */
    UserQuestionLog insert(UserQuestionLog userQuestionLog);

    /**
     * 修改数据
     *
     * @param userQuestionLog 实例对象
     * @return 实例对象
     */
    UserQuestionLog update(UserQuestionLog userQuestionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    QuestionSummaryVo getQuestionSummary(String questionId);
}