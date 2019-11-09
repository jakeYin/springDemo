package com.dream.demo.controller;

import com.dream.demo.entity.Dictionary;
import com.dream.demo.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 字典表(Dictionary)表控制层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dictionary selectOne(String id) {
        return this.dictionaryService.queryById(id);
    }

}