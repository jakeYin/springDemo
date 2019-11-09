package com.dream.demo.utils;

public class UserMgr {

    public static String getUserId(){
        return InvocationContext.getContext().getUserId();
    }
}
