package com.example.job.quartz.job;

import com.example.job.util.DateUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
@Slf4j
@DisallowConcurrentExecution
public class TokenCronJob extends QuartzJobBean {


    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("MyCronJob任务执行了,开始时间为{}" , DateUtils.dateToString(new Date()));
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}