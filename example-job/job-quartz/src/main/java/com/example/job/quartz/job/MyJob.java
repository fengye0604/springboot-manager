package com.example.job.quartz.job;

import com.example.job.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.quartz.job
 * @author:yanggaoli
 * @createTime:2021/7/19 23:06
 * @version:1.0
 */
@Slf4j
public class MyJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("MyJob任务执行了,开始时间为{}" , DateUtils.dateToString(new Date()));
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
