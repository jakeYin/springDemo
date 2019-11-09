package com.dream.demo.service.impl;

import com.dream.demo.entity.QuestionOption;
import com.dream.demo.dao.QuestionOptionDao;
import com.dream.demo.service.QuestionOptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (QuestionOption)表服务实现类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Service("questionOptionService")
public class QuestionOptionServiceImpl implements QuestionOptionService {
    @Resource
    private QuestionOptionDao questionOptionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public QuestionOption queryById(String id) {
        return this.questionOptionDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param questionOption 实例对象
     * @return 对象列表
     */
    public List<QuestionOption> queryAll(QuestionOption questionOption){
		return this.questionOptionDao.queryAll(questionOption);
	}


    /**
     * 新增数据
     *
     * @param questionOption 实例对象
     * @return 实例对象
     */
    @Override
    public QuestionOption insert(QuestionOption questionOption) {
        this.questionOptionDao.insert(questionOption);
        return questionOption;
    }

    /**
     * 修改数据
     *
     * @param questionOption 实例对象
     * @return 实例对象
     */
    @Override
    public QuestionOption update(QuestionOption questionOption) {
        this.questionOptionDao.update(questionOption);
        return this.queryById(questionOption.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.questionOptionDao.deleteById(id) > 0;
    }
}