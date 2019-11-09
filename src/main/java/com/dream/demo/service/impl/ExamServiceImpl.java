package com.dream.demo.service.impl;

import com.dream.demo.entity.Exam;
import com.dream.demo.dao.ExamDao;
import com.dream.demo.service.ExamService;
import com.dream.demo.vo.ExamVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表服务实现类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamDao examDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Exam queryById(String id) {
        return this.examDao.queryById(id);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param exam 实例对象
     * @return 对象列表
     */
    public List<Exam> queryAll(Exam exam){
		return this.examDao.queryAll(exam);
	}

    @Override
    public List<ExamVo> queryExamListByType(ExamVo vo) {
        return this.examDao.queryExamListByType(vo);
    }


    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam insert(Exam exam) {
        this.examDao.insert(exam);
        return exam;
    }

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam update(Exam exam) {
        this.examDao.update(exam);
        return this.queryById(exam.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.examDao.deleteById(id) > 0;
    }
}