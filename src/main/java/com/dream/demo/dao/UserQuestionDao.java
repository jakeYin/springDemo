package com.dream.demo.dao;

import com.dream.demo.entity.UserQuestion;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * (UserQuestion)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-05 14:56:10
 */
@Mapper
public interface UserQuestionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserQuestion queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userQuestion 实例对象
     * @return 对象列表
     */
    List<UserQuestion> queryAll(UserQuestion userQuestion);

    /**
     * 新增数据
     *
     * @param userQuestion 实例对象
     * @return 影响行数
     */
    int insert(UserQuestion userQuestion);

    /**
     * 修改数据
     *
     * @param userQuestion 实例对象
     * @return 影响行数
     */
    int update(UserQuestion userQuestion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    int deleteByExamQuestionId(String id);

    int insertBatch(List<UserQuestion> userQuestionList);

    void cleanAnswer(UserQuestion userQuestion);
}