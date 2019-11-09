package com.dream.demo.dic;

import java.lang.annotation.*;
 
/**
 * 说明：数据字典处理类
 * Created by luojie on 2019/05/29.
 */
//@DataDict(  dict="patType", source = "patType" )
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataDict {


    /**
     * 方法描述 描述标准编码
     *
     * @return
     */
    String dict() default "";

    /**
     * 方法描述,可使用占位符获取参数:{{source}}
     * 主要标准编码之来源
     */
    String source() default "";

}