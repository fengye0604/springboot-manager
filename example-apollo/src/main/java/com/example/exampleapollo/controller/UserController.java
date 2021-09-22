package com.example.exampleapollo.controller;


import com.example.exampleapollo.entity.UserEntity;
import com.example.exampleapollo.service.impl.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoli.yang
 * @since 2021-09-21
 */
@RestController
@RequestMapping("/user-entity")
public class UserController {
    @Resource
    public UserService userService;
    @PostMapping("/getUser")
    public UserEntity getUser(){
        return userService.getById(1);
    }


    @PostMapping("/test")
    public UserEntity test() throws NoSuchAlgorithmException {
        //确定计算方法
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String str = "apple";
        String newstr=base64en.encode(md5.digest(str.getBytes()));
        return userService.getById(1);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException{
        //确定计算方法
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String str = "a123456";
        long l = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(l);

        System.out.println(timestamp);
        //String newstr=base64en.encode(md5.digest(str.getBytes()));
        //System.out.printf(newstr);
        for (int i= 0 ;i<600;i++){
            Calendar cal = Calendar.getInstance();

            cal.setTimeInMillis(timestamp.getTime());

            cal.add(Calendar.SECOND, 15*i);

            Timestamp time = new Timestamp(cal.getTime().getTime());
            String data = str+time;
            String newData=base64en.encode(md5.digest(data.getBytes()));
            System.out.println(str+"\t"+time+"\t"+newData);
        }
    }
}
