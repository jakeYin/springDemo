package com.dream.demo.entity;

import java.io.Serializable;

/**
 * 字典表(Dictionary)实体类
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
public class Dictionary implements Serializable {
    private static final long serialVersionUID = -53916578087861352L;
    //主键
    private String id;
    //字典项名称
    private String name;
    //字典项编码
    private String code;
    //字典项顺序
    private String sort;
    //父类CODE
    private String parentCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

}