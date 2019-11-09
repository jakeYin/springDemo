package com.dream.demo.dao;

import com.dream.demo.entity.Exam;

import java.util.List;

import com.dream.demo.vo.ExamVo;
import org.apache.ibatis.annotations.Mapper;
/**
 * (Exam)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Mapper
public interface ExamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Exam queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param exam 实例对象
     * @return 对象列表
     */
    List<Exam> queryAll(Exam exam);

    List<ExamVo> queryExamListByType(ExamVo vo);

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}