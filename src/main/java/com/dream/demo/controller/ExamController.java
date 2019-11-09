package com.dream.demo.controller;

import com.dream.demo.entity.Exam;
import com.dream.demo.service.ExamService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表控制层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@RestController
@RequestMapping("exam")
public class ExamController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Exam selectOne(String id) {
        return this.examService.queryById(id);
    }

    /**
     * 综合查询
     *
     * @param exam 主键
     * @return 单条数据
     */
    @Cacheable(value = "AllExamService",unless="#result == null")
    @GetMapping("queryAll")
    public List<Exam> queryAll(Exam exam) {
        return this.examService.queryAll(exam);
    }

}