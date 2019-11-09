package com.dream.demo.controller;

import com.dream.demo.entity.UserQuestion;
import com.dream.demo.service.UserQuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserQuestion)表控制层
 *
 * @author makejava
 * @since 2019-10-05 14:56:10
 */
@RestController
@RequestMapping("userQuestion")
public class UserQuestionController {
    /**
     * 服务对象
     */
    @Resource
    private UserQuestionService userQuestionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserQuestion selectOne(String id) {
        return this.userQuestionService.queryById(id);
    }

}