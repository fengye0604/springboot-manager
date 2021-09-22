package com.example.exampleapollo.controller;


import com.example.exampleapollo.config.JavaConfigBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    public JavaConfigBean javaConfigBean;
    @RequestMapping("/test")
    public ResponseEntity<String> test(String message){
        return ResponseEntity.ok(message+javaConfigBean.getTimeout());
    }
}
