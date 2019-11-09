package com.dream.demo.dao;

import com.dream.demo.entity.Dictionary;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * 字典表(Dictionary)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Mapper
public interface DictionaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dictionary queryById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionary 实例对象
     * @return 对象列表
     */
    List<Dictionary> queryAll(Dictionary dictionary);

    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int insert(Dictionary dictionary);

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int update(Dictionary dictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}