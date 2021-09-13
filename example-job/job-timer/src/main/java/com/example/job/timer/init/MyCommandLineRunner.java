package com.example.job.timer.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.timer.init
 * @author:yanggaoli
 * @createTime:2021/7/18 15:01
 * @version:1.0
 */
@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("-----------》我是MyCommandLineRunner的run方法执行了！");
    }
}
