package com.example.exampleredis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
    private static Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Scheduled(cron = "0 0/1 * * * ?")
    private void test1() {
        logger.info("cron表达式");
    }

    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    private void test2() {
        logger.info("延迟2s运行第一次，然后每隔3s运行一次");
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 4000)
    private void test3() {
        logger.info("延迟3s运行第一次，上一次任务运行结束后等4s再运行下一次任务。");
    }
}