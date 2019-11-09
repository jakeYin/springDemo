package com.dream.demo.controller;

import com.dream.demo.entity.UserQuestionLog;
import com.dream.demo.service.UserQuestionLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserQuestionLog)表控制层
 *
 * @author makejava
 * @since 2019-10-05 15:12:06
 */
@RestController
@RequestMapping("userQuestionLog")
public class UserQuestionLogController {
    /**
     * 服务对象
     */
    @Resource
    private UserQuestionLogService userQuestionLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserQuestionLog selectOne(String id) {
        return this.userQuestionLogService.queryById(id);
    }

}