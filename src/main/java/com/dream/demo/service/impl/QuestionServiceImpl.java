package com.dream.demo.service.impl;

import com.dream.demo.entity.Question;
import com.dream.demo.dao.QuestionDao;
import com.dream.demo.service.QuestionService;
import com.dream.demo.vo.QuestionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Question queryById(String id) {
        return this.questionDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param question 实例对象
     * @return 对象列表
     */
    public List<Question> queryAll(Question question){
		return this.questionDao.queryAll(question);
	}

    @Override
    public List<QuestionVo> queryByExamId(String id) {
        return this.questionDao.queryByExamId(id);
    }


    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question insert(Question question) {
        this.questionDao.insert(question);
        return question;
    }

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question update(Question question) {
        this.questionDao.update(question);
        return this.queryById(question.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.questionDao.deleteById(id) > 0;
    }
}