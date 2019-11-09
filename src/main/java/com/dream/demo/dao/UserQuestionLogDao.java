package com.dream.demo.dao;

import com.dream.demo.entity.UserQuestionLog;

import java.util.List;

import com.dream.demo.vo.QuestionSummaryVo;
import org.apache.ibatis.annotations.Mapper;
/**
 * (UserQuestionLog)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-05 15:12:06
 */
@Mapper
public interface UserQuestionLogDao {

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
     * @return 影响行数
     */
    int insert(UserQuestionLog userQuestionLog);

    /**
     * 修改数据
     *
     * @param userQuestionLog 实例对象
     * @return 影响行数
     */
    int update(UserQuestionLog userQuestionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    QuestionSummaryVo getQuestionSummary(String questionId);
}