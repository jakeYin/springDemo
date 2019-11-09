package com.dream.demo.utils;

import org.springframework.util.Assert;

import java.lang.reflect.Field;

public class BeanUtils {


    /**
     * 获取当前类声明的private/protected变量
     */
    static public Object getFieldValue(Object object, String propertyName)
            throws IllegalAccessException, NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        Field field = object.getClass().getDeclaredField(propertyName);
        field.setAccessible(true);

        return field.get(object);
    }

    /**
     * zhangpf :因为getFieldValue()方法，无法读取super class的属性的值；
     * 所以本方法做出扩展，允许读取super class的属性的值；
     *
     * @param object
     * @param propertyName
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static Object getFieldValueInAllSuper(Object object, String propertyName)
            throws IllegalAccessException, NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        Class claszz = object.getClass();
        Field field = null;

        do {
            try {
                field = claszz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
                field = null;
            }
            claszz = claszz.getSuperclass();
        }
        while (field == null && claszz != null);

        if (field == null) return null;

        field.setAccessible(true);
        return field.get(object);
    }
}

