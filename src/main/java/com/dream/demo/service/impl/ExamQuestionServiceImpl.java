package com.dream.demo.service.impl;

import com.dream.demo.entity.ExamQuestion;
import com.dream.demo.dao.ExamQuestionDao;
import com.dream.demo.service.ExamQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ExamQuestion)表服务实现类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Service("examQuestionService")
public class ExamQuestionServiceImpl implements ExamQuestionService {
    @Resource
    private ExamQuestionDao examQuestionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ExamQuestion queryById(String id) {
        return this.examQuestionDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param examQuestion 实例对象
     * @return 对象列表
     */
    public List<ExamQuestion> queryAll(ExamQuestion examQuestion){
		return this.examQuestionDao.queryAll(examQuestion);
	}


    /**
     * 新增数据
     *
     * @param examQuestion 实例对象
     * @return 实例对象
     */
    @Override
    public ExamQuestion insert(ExamQuestion examQuestion) {
        this.examQuestionDao.insert(examQuestion);
        return examQuestion;
    }

    /**
     * 修改数据
     *
     * @param examQuestion 实例对象
     * @return 实例对象
     */
    @Override
    public ExamQuestion update(ExamQuestion examQuestion) {
        this.examQuestionDao.update(examQuestion);
        return this.queryById(examQuestion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.examQuestionDao.deleteById(id) > 0;
    }
}