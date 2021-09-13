package com.example.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.dubbo.consumer.controller
 * @author:yanggaoli
 * @createTime:2021/9/13 0:27
 * @version:1.0
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
