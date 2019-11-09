package com.dream.demo.constant;

public enum ReturnCode  {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    ALREADY_GENERATE_RECORD(5001, "已经生成试题"),
    NO_USERNAME(5002, "请输入用户名"),
    NO_PASSWORD(5003, "请输入密码"),
    WRONG_USERNAME_PASSWORD(5004, "用户名密码错误"),
    ALREADY_EXIST_USERNAME(5005, "用户名已存在"),
    ALREADY_LOGOUT(5006, "已经登出账号"),
    INVALID_TOKEN(5007, "失效的token"),

    ;

    private Integer code;

    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}