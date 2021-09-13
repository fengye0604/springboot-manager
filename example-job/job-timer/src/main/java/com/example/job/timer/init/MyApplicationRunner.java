package com.example.job.timer.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.timer.init
 * @author:yanggaoli
 * @createTime:2021/7/18 15:02
 * @version:1.0
 */
@Slf4j
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("-----------》我是MyApplicationRunner的run方法执行了！");
    }
}
