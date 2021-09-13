package com.example.shiro.controller;

import com.example.examplespringbootstarter.annotation.MyLog;
import com.example.examplespringbootstarter.service.DemoService;
import com.example.shiro.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    private DemoService demoService;


    @GetMapping("/login")
    public String login(User user) {
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return "请输入用户名和密码！";
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息

            subject.login(usernamePasswordToken);

//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        }catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            return "账号或密码错误！";
        }catch (AuthorizationException e) {
            log.error("没有权限！", e);
            return "没有权限";
        }
        return "login success";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin success!";
    }

//    @RequiresPermissions("query")
    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

//    @RequiresPermissions("add")
//    @RequiresRoles("add")
    @GetMapping("/add")
    public String add() {
        log.info(new Date().toString());
        return "add success 111!";
    }
    @GetMapping("/error")
    public String error() {

        return new Date().toString()+"error  111!";
    }

    @GetMapping("/test")
    public String test() {

        return new Date().toString()+"test  111!";
    }


    @GetMapping("/say")
    @MyLog(desc = "测试方法")
    public String sayWhat(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        return demoService.say();
    }
}
