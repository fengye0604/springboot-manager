package com.example.examplezklock.model;

import com.sun.jmx.snmp.tasks.ThreadService;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.model
 * @author:yanggaoli
 * @createTime:2021/9/4 21:53
 * @version:1.0
 */
public class MyData implements Runnable{
    private int count = 100;
    private CountDownLatch countDownLatch ;
    private InterProcessSemaphoreMutex interProcessSemaphoreMutex;
    public MyData(){

    }
    public MyData(CountDownLatch countDownLatch,InterProcessSemaphoreMutex interProcessSemaphoreMutex){
        this.countDownLatch = countDownLatch;
        this.interProcessSemaphoreMutex = interProcessSemaphoreMutex;
    }


    public int getCount() {
        return count;

    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
            interProcessSemaphoreMutex.acquire();
//            synchronized (this){
                count = count-1;
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("countDownLatch的数量是"+countDownLatch.getCount());
            try {
                // 释放锁资源
                interProcessSemaphoreMutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }
    
    
    public static void main(String[] args){
        /*
        CountDownLatch countDownLatch = new CountDownLatch(10);
        MyData data = new MyData(countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < 10; i++){
            executorService.execute(data);
            System.out.println(i);
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }


        System.out.println(data.getCount());
        */
    }

}
