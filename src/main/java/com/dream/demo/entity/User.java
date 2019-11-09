package com.dream.demo.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-10-10 22:45:13
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -74451063078909589L;
    
    private String id;
    //用户名
    private String userName;
    //密码
    private String password;
    //电话
    private String phone;
    //token
    private String token;


}