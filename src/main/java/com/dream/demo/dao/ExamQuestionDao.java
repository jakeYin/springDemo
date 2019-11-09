package com.dream.demo.dao;

import com.dream.demo.entity.ExamQuestion;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * (ExamQuestion)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Mapper
public interface ExamQuestionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ExamQuestion queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param examQuestion 实例对象
     * @return 对象列表
     */
    List<ExamQuestion> queryAll(ExamQuestion examQuestion);

    /**
     * 新增数据
     *
     * @param examQuestion 实例对象
     * @return 影响行数
     */
    int insert(ExamQuestion examQuestion);

    /**
     * 修改数据
     *
     * @param examQuestion 实例对象
     * @return 影响行数
     */
    int update(ExamQuestion examQuestion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}