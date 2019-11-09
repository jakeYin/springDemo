package com.dream.demo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 捕获异常的类，返回信息给浏览器，可以自定义返回的code,msg等信息
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof CustomException) {   //判断异常是否是我们定义的异常
            CustomException customException = (CustomException) e;
            return ResultUtil.error(customException.getCode(), customException.getMessage());
        } else if (e instanceof NoHandlerFoundException) {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(404, "未找到接口");
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }


}