package com.example.job.quartz.config;

import com.example.job.quartz.job.MyJob;
import com.example.job.quartz.job.TokenCronJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

	// 使用jobDetail包装job
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class)
                         .withIdentity("myJob","group1")
                         .storeDurably()
                         .build();
    }

	// 把jobDetail注册到trigger上去
    @Bean
    public Trigger myJobTrigger() {
        //间隔15秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15)//每隔15秒执行一次
                .repeatForever();//一直执行

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

	// 使用jobDetail包装job
    @Bean
    public JobDetail myCronJobDetail() {
        return JobBuilder.newJob(TokenCronJob.class)
                .withIdentity("tokenCronJob")
                .storeDurably()
                .build();
    }

	// 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTrigger() {
        //指定时间执行。
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(myCronJobDetail())
                .withIdentity("tokenCronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}