package com.example.dubbo.consumer.controller;

import com.example.dubbo.consumer.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/getMsg")
    public String getMsg(String str) {
        return this.demoService.getMsg(str);
    }

    //这里修改了代码

}