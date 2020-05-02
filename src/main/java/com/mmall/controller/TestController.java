package com.mmall.controller;

import com.mmall.common.JsonData;
import com.mmall.dao.SysAclModuleMapper;
import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import com.mmall.param.TestVo;
import com.mmall.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        log.info("hello");
//        return "hello,permission";
//    }


    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new RuntimeException("test exception");
//        return JsonData.success("hello, permission");
    }

//    @RequestMapping("/validate.json")
//    @ResponseBody
//    public JsonData validate(TestVo vo) {
//        log.info("validate");
//        try {
//            Map<String,String> map = BeanValidator.validateObject(vo);
//            if(MapUtils.isNotEmpty(map)){
//                for(Map.Entry<String,String> entry :  map.entrySet()){
//                    log.info("{}-{}",entry.getKey(),entry.getValue());
//                }
//            }
//        }catch(Exception e){
//
//        }
//
//        return JsonData.success("test validate");
//    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
//        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
//        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
//        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
