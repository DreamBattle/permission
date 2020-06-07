package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class HttpIntercepter extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    //请求之前处理方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map partameterMap = request.getParameterMap();
        log.info("url{},start.param{}",url, JsonMapper.obj2String(partameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    //请求正常结束后的处理方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url = request.getRequestURI().toString();
//        long start = (long) request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
//        log.info("url{},finished.param{}",url, end-start);
    }

    //不论请求时正常结束还是异常结束都会调用的处理方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("url{},exception.param{}",url, end-start);
    }
}
