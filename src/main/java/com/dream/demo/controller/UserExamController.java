package com.dream.demo.controller;

import com.dream.demo.entity.UserExam;
import com.dream.demo.service.UserExamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserExam)表控制层
 *
 * @author makejava
 * @since 2019-10-05 15:24:20
 */
@RestController
@RequestMapping("userExam")
public class UserExamController {
    /**
     * 服务对象
     */
    @Resource
    private UserExamService userExamService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserExam selectOne(String id) {
        return this.userExamService.queryById(id);
    }

}