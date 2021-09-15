package com.example.examplerest.controller;


import com.example.examplerest.exception.MyException;
import com.example.examplerest.exception.SubMyException;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplerest
 * @author:yanggaoli
 * @createTime:2021/9/14 23:31
 * @version:1.0
 */
@RestController
@RequestMapping("/test")
public class TestRestController {
    @RequestMapping("/name")
    public ResponseEntity getName(@RequestParam("name") String name) throws Exception{
        try {
            int i = 5/0;
        } catch (Exception e) {
            throw new SubMyException(1000, e.getMessage()+"====");
        }
        return ResponseEntity.ok(name+"弄好呀！");
    }
}
