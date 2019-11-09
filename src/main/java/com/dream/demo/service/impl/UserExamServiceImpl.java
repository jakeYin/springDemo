package com.dream.demo.service.impl;

import com.dream.demo.entity.UserExam;
import com.dream.demo.dao.UserExamDao;
import com.dream.demo.service.UserExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserExam)表服务实现类
 *
 * @author makejava
 * @since 2019-10-05 15:24:20
 */
@Service("userExamService")
public class UserExamServiceImpl implements UserExamService {
    @Resource
    private UserExamDao userExamDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserExam queryById(String id) {
        return this.userExamDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param userExam 实例对象
     * @return 对象列表
     */
    public List<UserExam> queryAll(UserExam userExam){
		return this.userExamDao.queryAll(userExam);
	}


    /**
     * 新增数据
     *
     * @param userExam 实例对象
     * @return 实例对象
     */
    @Override
    public UserExam insert(UserExam userExam) {
        this.userExamDao.insert(userExam);
        return userExam;
    }

    /**
     * 修改数据
     *
     * @param userExam 实例对象
     * @return 实例对象
     */
    @Override
    public UserExam update(UserExam userExam) {
        this.userExamDao.update(userExam);
        return this.queryById(userExam.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userExamDao.deleteById(id) > 0;
    }
}