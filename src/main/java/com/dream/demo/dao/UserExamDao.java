package com.dream.demo.dao;

import com.dream.demo.entity.UserExam;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * (UserExam)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-05 15:24:20
 */
@Mapper
public interface UserExamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserExam queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userExam 实例对象
     * @return 对象列表
     */
    List<UserExam> queryAll(UserExam userExam);

    /**
     * 新增数据
     *
     * @param userExam 实例对象
     * @return 影响行数
     */
    int insert(UserExam userExam);

    /**
     * 修改数据
     *
     * @param userExam 实例对象
     * @return 影响行数
     */
    int update(UserExam userExam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}