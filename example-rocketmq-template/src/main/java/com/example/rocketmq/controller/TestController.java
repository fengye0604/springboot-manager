package com.example.rocketmq.controller;

import com.example.examplecommon.model.ResultBean;
import com.example.rocketmq.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/testMessage")
    public ResultBean test(@RequestParam String message){
        return testService.test(message);
    }

}
