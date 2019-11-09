package com.dream.demo.dao;

import com.dream.demo.entity.QuestionOption;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * (QuestionOption)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Mapper
public interface QuestionOptionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuestionOption queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param questionOption 实例对象
     * @return 对象列表
     */
    List<QuestionOption> queryAll(QuestionOption questionOption);

    /**
     * 新增数据
     *
     * @param questionOption 实例对象
     * @return 影响行数
     */
    int insert(QuestionOption questionOption);

    /**
     * 修改数据
     *
     * @param questionOption 实例对象
     * @return 影响行数
     */
    int update(QuestionOption questionOption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}