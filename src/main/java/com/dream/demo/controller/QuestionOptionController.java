package com.dream.demo.controller;

import com.dream.demo.entity.QuestionOption;
import com.dream.demo.service.QuestionOptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (QuestionOption)表控制层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@RestController
@RequestMapping("questionOption")
public class QuestionOptionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionOptionService questionOptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public QuestionOption selectOne(String id) {
        return this.questionOptionService.queryById(id);
    }

}