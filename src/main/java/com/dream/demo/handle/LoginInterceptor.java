package com.dream.demo.handle;

import com.dream.demo.constant.ReturnCode;
import com.dream.demo.service.UserService;
import com.dream.demo.entity.User;
import com.dream.demo.utils.InvocationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        User user = userService.queryByToken(token);
        if (user == null){
            throw new CustomException(ReturnCode.INVALID_TOKEN);
        }else {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(user,null);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            InvocationContext.initThreadContext(user);
            return true;
        }
    }
 
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        InvocationContext.clear();
    }
}