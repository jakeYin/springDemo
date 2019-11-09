package com.dream.demo.handle;

import com.dream.demo.constant.ReturnCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;

@ControllerAdvice
public class RestControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        // 对body进行封装处理
       if (body instanceof Result) {
            return body;
        } else if (body instanceof LinkedHashMap){
           LinkedHashMap map = (LinkedHashMap) body;
           if (map.get("status").equals("401")){
               CustomException customException = new CustomException(ReturnCode.INVALID_TOKEN);
               return ResultUtil.error(customException.getCode(), customException.getMessage());
           } else {
               return ResultUtil.success(body);
           }
       } else {
           return ResultUtil.success(body);
       }
    }
}