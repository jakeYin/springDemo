package com.dream.demo.dao;

import com.dream.demo.entity.Question;

import java.util.List;

import com.dream.demo.vo.QuestionVo;
import org.apache.ibatis.annotations.Mapper;
/**
 * (Question)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Mapper
public interface QuestionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Question queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param question 实例对象
     * @return 对象列表
     */
    List<Question> queryAll(Question question);


    List<QuestionVo> queryByExamId(String id);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 影响行数
     */
    int insert(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 影响行数
     */
    int update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}