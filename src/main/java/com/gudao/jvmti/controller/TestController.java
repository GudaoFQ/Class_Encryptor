package com.gudao.jvmti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Gudao
 * @Date: 2021/7/22
 * @Description:
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "testInfo 测试信息";
    }
}
