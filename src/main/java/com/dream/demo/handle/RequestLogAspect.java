package com.dream.demo.handle;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Aspect
public class RequestLogAspect {
    private final Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.example.demo.controller..*(..))")
    public void requestServer() {
    }

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        methodBefore(pjp, uuid);
        Object proceed = null;
        try {
            proceed = pjp.proceed();
            methodAfterReturing(proceed, uuid);
        } catch (Exception e) {
            logger.error("[{}]Response异常内容:{}", uuid, e);
            throw e;
        }
        return proceed;
    }

    public void methodBefore(JoinPoint joinPoint, String uuid) {
        // 打印请求内容
        try {
            // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。
            Object[] objs = joinPoint.getArgs();
            String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
            Map<String, Object> paramMap = new HashMap<String, Object>();
            for (int i = 0; i < objs.length; i++) {
                if (!(objs[i] instanceof ExtendedServletRequestDataBinder) && !(objs[i] instanceof HttpServletResponseWrapper)) {
                    paramMap.put(argNames[i], objs[i]);
                }
            }

            if (paramMap.size() > 0) {
                logger.info("\n[{}]方法:{}\n参数:{}", uuid, joinPoint.getSignature(), JSON.toJSONString(paramMap));
            }
        } catch (Exception e) {
            logger.error("[{}]AOP methodBefore:", uuid, e);
        }
    }

    public void methodAfterReturing(Object o, String uuid) {
        try {
            if (o != null)
                logger.info("[{}]Response内容:{}", uuid, JSON.toJSONString(o));
        } catch (Exception e) {
            logger.error("[{}]AOP methodAfterReturing:", uuid, e);
        }
    }

}