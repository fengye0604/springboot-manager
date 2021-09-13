package com.example.examplezklock.service;

import com.example.examplezklock.model.MyData;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.service
 * @author:yanggaoli
 * @createTime:2021/9/4 21:47
 * @version:1.0
 */
@Service
public class MyTestService {
    @Autowired
    private CuratorFramework curatorFramework;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    public int getCount(int count) {


        InterProcessSemaphoreMutex interProcessSemaphoreMutex = new InterProcessSemaphoreMutex(curatorFramework, "/zktest/count");
        CountDownLatch countDownLatch = new CountDownLatch(50);
        MyData data = new MyData(countDownLatch,interProcessSemaphoreMutex);

        for (int i = 0 ; i < 50; i++){
            threadPoolExecutor.execute(data);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        return data.getCount();
    }
}
