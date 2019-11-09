package com.dream.demo.service;

import com.dream.demo.entity.QuestionOption;
import java.util.List;

/**
 * (QuestionOption)表服务接口
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public interface QuestionOptionService {

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
     * @return 实例对象
     */
    QuestionOption insert(QuestionOption questionOption);

    /**
     * 修改数据
     *
     * @param questionOption 实例对象
     * @return 实例对象
     */
    QuestionOption update(QuestionOption questionOption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}