package com.dream.demo.service.impl;

import com.dream.demo.entity.Dictionary;
import com.dream.demo.dao.DictionaryDao;
import com.dream.demo.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典表(Dictionary)表服务实现类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryDao dictionaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dictionary queryById(String id) {
        return this.dictionaryDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionary 实例对象
     * @return 对象列表
     */
    public List<Dictionary> queryAll(Dictionary dictionary){
		return this.dictionaryDao.queryAll(dictionary);
	}


    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary insert(Dictionary dictionary) {
        this.dictionaryDao.insert(dictionary);
        return dictionary;
    }

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary update(Dictionary dictionary) {
        this.dictionaryDao.update(dictionary);
        return this.queryById(dictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.dictionaryDao.deleteById(id) > 0;
    }
}