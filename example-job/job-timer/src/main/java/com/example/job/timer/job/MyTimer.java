package com.example.job.timer.job;

import com.example.job.timer.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.timer.job
 * @author:yanggaoli
 * @createTime:2021/7/18 14:37
 * @version:1.0
 */
@Slf4j
@Component
public class MyTimer{

    public void testTimer() throws Exception {
        Timer timer = new Timer("Timer定时器");

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                log.info("MyTimer的testTimer方法执行，执行时间{}", DateUtils.dateToString(new Date()));
            }
        };
        //延迟5秒执行，以后每个十秒执行一次
        timer.schedule(tt ,5000,1000*10);
    }
}
