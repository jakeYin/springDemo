package com.dream.demo.service;

import com.dream.demo.entity.ExamQuestion;
import java.util.List;

/**
 * (ExamQuestion)表服务接口
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public interface ExamQuestionService {

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
     * @return 实例对象
     */
    ExamQuestion insert(ExamQuestion examQuestion);

    /**
     * 修改数据
     *
     * @param examQuestion 实例对象
     * @return 实例对象
     */
    ExamQuestion update(ExamQuestion examQuestion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}