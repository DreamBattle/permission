package com.mmall.common;

import com.mmall.exception.PermissionException;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//该reslover放到spring-servlet.xml中归spring管理
@Slf4j
public class SpringExceptionReslover implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";

        // .json .page
        //这里我们要求项目中所有请求json数据，都用.json结尾
        if(url.endsWith(".json")){
            if (e instanceof PermissionException){
                JsonData result = JsonData.fail(e.getMessage());
                //jsonView对应spring-servlet.xml中的jsonView
                mv = new ModelAndView("jsonView",result.toMap());
            }else {
                log.error("unknown json exception,url:"+url,e);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){//这里我们要求项目中所有请求page数据，都用.page结尾
            log.error("unknown page exception,url:"+url,e);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception",result.toMap());
        }else{
            log.error("unknown exception,url:"+url,e);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView",result.toMap());
        }
        return mv;
    }

}
