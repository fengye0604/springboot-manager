package com.example.examplezklock.service;

import com.example.examplecommon.util.DateUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 实现多个应用实例只一个执行定时任务
 *
 * @author 594781919@qq.com
 */
@Service
public class TimerTaskService {

    @Autowired
    private CuratorFramework curatorFramework;

    @Value("${server.port}")
    private String port;

    @Scheduled(cron = "0 0/5 * * * *")
    public void task() {
        LeaderLatch leaderLatch = new LeaderLatch(curatorFramework, "/timerTask");
        try {
            leaderLatch.start();
            // Leader选举需要一些时间，等待2秒
            Thread.sleep(2000);
            // 判断是否为主节点
            if (leaderLatch.hasLeadership()) {
                System.out.println(DateUtils.dateToStr(LocalDateTime.now()) + "    port=" + port + " 是领导");
                // 定时任务的业务逻辑代码
            } else {
                System.out.println(DateUtils.dateToStr(LocalDateTime.now()) + "    port=" + port + " 是从属");
            }
        } catch (Exception e) {
            System.out.println("这里出错了！{Leader选举}"+e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                leaderLatch.close();
            } catch (IOException e) {
                System.out.println("这里出错了！{leaderLatch.close()}"+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
