package com.dream.demo.service.impl;

import com.dream.demo.entity.UserQuestionLog;
import com.dream.demo.dao.UserQuestionLogDao;
import com.dream.demo.service.UserQuestionLogService;
import com.dream.demo.vo.QuestionSummaryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserQuestionLog)表服务实现类
 *
 * @author makejava
 * @since 2019-10-05 15:12:06
 */
@Service("userQuestionLogService")
public class UserQuestionLogServiceImpl implements UserQuestionLogService {
    @Resource
    private UserQuestionLogDao userQuestionLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserQuestionLog queryById(String id) {
        return this.userQuestionLogDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param userQuestionLog 实例对象
     * @return 对象列表
     */
    public List<UserQuestionLog> queryAll(UserQuestionLog userQuestionLog){
		return this.userQuestionLogDao.queryAll(userQuestionLog);
	}


    /**
     * 新增数据
     *
     * @param userQuestionLog 实例对象
     * @return 实例对象
     */
    @Override
    public UserQuestionLog insert(UserQuestionLog userQuestionLog) {
        this.userQuestionLogDao.insert(userQuestionLog);
        return userQuestionLog;
    }

    /**
     * 修改数据
     *
     * @param userQuestionLog 实例对象
     * @return 实例对象
     */
    @Override
    public UserQuestionLog update(UserQuestionLog userQuestionLog) {
        this.userQuestionLogDao.update(userQuestionLog);
        return this.queryById(userQuestionLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userQuestionLogDao.deleteById(id) > 0;
    }

    @Override
    public QuestionSummaryVo getQuestionSummary(String questionId) {
        return this.userQuestionLogDao.getQuestionSummary(questionId);
    }
}