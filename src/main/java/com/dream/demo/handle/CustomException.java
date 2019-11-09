package com.dream.demo.handle;


import com.dream.demo.constant.ReturnCode;

public class CustomException extends RuntimeException{    //注意：spring中，只有RuntimeException才会进行事务回滚，Exception不会进行事务回滚

    private Integer code;

    public CustomException(ReturnCode returnCode) {
        super(returnCode.getMsg());
        this.code = returnCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}