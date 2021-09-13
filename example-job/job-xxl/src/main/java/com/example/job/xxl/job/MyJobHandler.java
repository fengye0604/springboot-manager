package com.example.job.xxl.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author fueen
 * 编写自己的定时任务Handler
 * 继承IJobHandler
 *
 */

@Component
public class MyJobHandler{
    @XxlJob(value = "myXxlJobTest")
    public void myJobTest() throws Exception {
        System.out.println("自定义myXxlJobTest");
    }
}

