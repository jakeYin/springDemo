package com.dream.demo.service.impl;

import com.dream.demo.entity.UserQuestion;
import com.dream.demo.dao.UserQuestionDao;
import com.dream.demo.service.UserQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserQuestion)表服务实现类
 *
 * @author makejava
 * @since 2019-10-05 14:56:10
 */
@Service("userQuestionService")
public class UserQuestionServiceImpl implements UserQuestionService {
    @Resource
    private UserQuestionDao userQuestionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserQuestion queryById(String id) {
        return this.userQuestionDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param userQuestion 实例对象
     * @return 对象列表
     */
    public List<UserQuestion> queryAll(UserQuestion userQuestion){
		return this.userQuestionDao.queryAll(userQuestion);
	}


    /**
     * 新增数据
     *
     * @param userQuestion 实例对象
     * @return 实例对象
     */
    @Override
    public UserQuestion insert(UserQuestion userQuestion) {
        this.userQuestionDao.insert(userQuestion);
        return userQuestion;
    }

    /**
     * 修改数据
     *
     * @param userQuestion 实例对象
     * @return 实例对象
     */
    @Override
    public UserQuestion update(UserQuestion userQuestion) {
        this.userQuestionDao.update(userQuestion);
        return this.queryById(userQuestion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userQuestionDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByExamQuestionId(String id) {
        return this.userQuestionDao.deleteByExamQuestionId(id) > 0;
    }

    @Override
    public int insertBatch(List<UserQuestion> userQuestionList) {
        if (userQuestionList.size() > 0){
            return this.userQuestionDao.insertBatch(userQuestionList);
        } else {
            return 0;
        }
    }

    @Override
    public void cleanAnswer(UserQuestion userQuestion) {
        this.userQuestionDao.cleanAnswer(userQuestion);
    }
}