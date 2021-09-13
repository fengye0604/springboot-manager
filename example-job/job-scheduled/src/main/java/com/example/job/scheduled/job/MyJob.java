package com.example.job.scheduled.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.scheduled.job
 * @author:yanggaoli
 * @createTime:2021/7/18 20:30
 * @version:1.0
 */
@Slf4j
@Component
public class MyJob {
    @Scheduled(cron = "0/10 * * * * ?")
    public String testScheduled(){
        log.info("------》》》》 myJob的TestScheduled方法执行了！");
        return "lallallalla";
    }
}
