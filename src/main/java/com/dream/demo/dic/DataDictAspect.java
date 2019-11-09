package com.dream.demo.dic;

import com.dream.demo.entity.Dictionary;
import com.dream.demo.dao.DictionaryDao;
import com.xiaoleilu.hutool.util.ReflectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 
 
/**
 * 说明：数据字典切面类
 * Created by luojie on 2019/05/29.
 */
@Aspect
@Component
public class DataDictAspect {
 
    @Autowired
    DictionaryDao dictionaryDao;
 
    /**
     * 非基本类型在 CLASS 中的定义
     */
    private static final String FILED_NAME_TYPE = "TYPE";
 
    private Map<String, String> dictInfoMap = new ConcurrentHashMap<>();
 
    @Pointcut("@annotation(dataDictClass)")
    public void doDataDictClass(DataDictClass dataDictClass) {
    }
 
    @Around("@annotation(dataDictClass)")
    public Object translation(final ProceedingJoinPoint pjp, DataDictClass dataDictClass) throws Throwable {
        Object result = pjp.proceed();
        if (result == null) {
            return result;
        }
        Object obj;
        if (result instanceof List || result instanceof ArrayList) {
            List olist = ((List) result);
            if (olist.size() == 0) {
                return result;
            }
            obj = olist.get(0);
        } else {
            obj = result;
        }
        List<Map<String, String>> dictParams = boDict(obj.getClass());
        if (dictParams.size() == 0) {
            return result;
        }
        //TODO 后期需优化读取Redis
        List<Dictionary> dictInfos = dictionaryDao.queryAll(null);
 
        if (dictInfos == null && dictInfos.size() == 0) {
            return result;
        }
        //先把字典值转成map
        for (Dictionary dictionary : dictInfos) {
            dictInfoMap.put(dictionary.getCode(), dictionary.getName());
        }
 
        if (result instanceof List || result instanceof ArrayList) {
            for (Object o : (List) result) {
                singleTranslation(o, dictParams, dictInfoMap);
            }
        } else {
            singleTranslation(result, dictParams, dictInfoMap);
        }
        return result;
    }
 
//    /**
//     * 单个设置值
//     *
//     * @param obj
//     * @param dictParams
//     * @param dictInfoMap
//     */
//    public void sign(Object obj, List<Map<String, String>> dictParams, Map<String, String> dictInfoMap) {
//
//        for (Map<String, String> dictParam : dictParams) {
//            String dict = dictParam.get("dict");
//            String source = dictParam.get("source");
//            String dictName = dictParam.get("dictName");
//            try {
//                //获取源编码值
//                String sourceValue = (String) BeanUtils.getFieldValue(obj.getClass(), obj, source);
//                String dictCodeName = dictInfoMap.get(dict + sourceValue);
//                //设置值
//                BeanUtils.setBeanField(obj.getClass(), obj, dictName, dictCodeName);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }

    public void singleTranslation(Object result, List<Map<String,String>> dictParams, Map<String,String> dictInfoMap) {
        for (Map<String,String> dictParam : dictParams) {
            String codeType = dictParam.get("codeType");
            String dictField = dictParam.get("dictField");
            String dictFieldName = dictParam.get("dictFieldName");
            String sourceValue = (String) ReflectUtil.getFieldValue(result, dictField);
            String dictValue = dictInfoMap.get(codeType + "-" + sourceValue);
            ReflectUtil.setFieldValue(result, dictFieldName, dictValue);
        }
    }


 
    /**
     * 获取bo中属性值
     *
     * @param cla
     * @return
     */
    private List<Map<String, String>> boDict(Class cla) {
        Field[] fields = cla.getDeclaredFields();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        DataDict dataDict;
        for (Field field : fields) {
            if (field.isAnnotationPresent(DataDict.class)) {
                map = new HashMap<String, String>();
                dataDict = field.getAnnotation(DataDict.class);
                map.put("dict", dataDict.dict());
                map.put("source", dataDict.source());
                map.put("dictName", field.getName());
                list.add(map);
            }
        }
        return list;
    }
 
 
  
 
 
}
