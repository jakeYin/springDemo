package com.dream.demo.utils;

import com.dream.demo.entity.User;

import java.util.Map;

public class InvocationContext {
    private static final ThreadLocal<InvocationContext> context =
        new ThreadLocal<InvocationContext>();

    private User user;
    private Map<String, String> params;

    private InvocationContext(Map<String, String> params) {
        this.params = params;
    }

    private InvocationContext(User user) {
        this.user = user;
    }

    public static InvocationContext getContext() {
        return context.get();
    }

    public static void initContext(Map<String, String> params) {
        context.set(new InvocationContext(params));
    }

    public static void clear() {
        context.set(null);
        context.remove();
    }


    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getParam(String param) {
        return params.get(param);
    }

    public String getUserId() {
        return user == null ? "" : user.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 设置会话级别的session元素值
     * @param user
     */
    public static void initThreadContext(User user) {
        context.set(new InvocationContext(user));
    }
}