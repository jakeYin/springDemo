package com.dream.demo.vo;

import lombok.Data;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-10-10 22:45:13
 */
@Data
public class UserVo{

    private String id;
    //用户名
    private String userName;
    //电话
    private String phone;
    //token
    private String token;


}