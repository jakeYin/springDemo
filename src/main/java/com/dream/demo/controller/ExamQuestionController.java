package com.dream.demo.controller;

import com.dream.demo.entity.ExamQuestion;
import com.dream.demo.service.ExamQuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ExamQuestion)表控制层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@RestController
@RequestMapping("examQuestion")
public class ExamQuestionController {
    /**
     * 服务对象
     */
    @Resource
    private ExamQuestionService examQuestionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ExamQuestion selectOne(String id) {
        return this.examQuestionService.queryById(id);
    }

}