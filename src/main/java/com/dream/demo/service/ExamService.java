package com.dream.demo.service;

import com.dream.demo.entity.Exam;
import com.dream.demo.vo.ExamVo;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * (Exam)表服务接口
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public interface ExamService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Cacheable(value = "ExamService", key = "#id", unless="#result == null")
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
     * @return 实例对象
     */
    Exam insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    Exam update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}