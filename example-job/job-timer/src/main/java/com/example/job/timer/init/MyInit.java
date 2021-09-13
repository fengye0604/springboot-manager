package com.example.job.timer.init;

import com.example.job.timer.job.MyTimer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.timer.init
 * @author:yanggaoli
 * @createTime:2021/7/18 15:06
 * @version:1.0
 */
@Slf4j
@Component
public class MyInit implements InitializingBean {
    @Autowired
    MyTimer myTimer;
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-----------》我是MyInit的afterPropertiesSet方法执行了！");

       myTimer.testTimer();
    }
}
