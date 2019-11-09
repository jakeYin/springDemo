package com.dream.demo.utils;

import java.util.UUID;

public class UUIDUtil {
    public static String generatId(){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        return id;
    }
}
