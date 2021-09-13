package com.example.elasticjob.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.elasticjob.test
 * @author:yanggaoli
 * @createTime:2021/7/17 23:36
 * @version:1.0
 */
public class TimerTest {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args){
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务执行了！"+sdf.format(new Date()));
            }
        };

        Timer timer = new Timer("定时任务");
        timer.schedule(tt,1000*10L,1500*10L);


    }
}
