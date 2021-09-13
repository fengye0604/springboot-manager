package com.example.examplezklock.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * @author 594781919
 */
@Service
@Slf4j
public class ListenerService {
    private final CuratorFramework curatorFramework;
    private NodeCache nodeCache;

    public static final String path = "/hello/world";

    public ListenerService(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;

    }

    public void listener() {
        try {
            // 创建路径
            Stat stat = curatorFramework.checkExists().forPath(path);
            if (stat == null) {
                curatorFramework.create().creatingParentsIfNeeded().forPath(path);
            }
        } catch (Exception e) {
            System.out.println("这里出错了！{创建路径}"+e.getMessage());
            e.printStackTrace();
        }
        nodeCache = new NodeCache(curatorFramework, path);
        // 添加监听的路径改变后需要执行的任务
        nodeCache.getListenable().addListener(this::run);
        try {
            nodeCache.start();
        } catch (Exception e) {
            System.out.println("这里出错了！{添加监听的路径改变后需要执行的任务}"+e.getMessage());

            e.printStackTrace();
        }
        System.out.println("开始监听......");
    }

    @PreDestroy
    public void preDestroy() {
        CloseableUtils.closeQuietly(nodeCache);
    }

    public void notifyNodeCache() {
        try {
            curatorFramework.setData().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	// 需要执行的调度任务
    private void run() {
        System.out.println(new Date().toLocaleString() + ", 开始执行监听任务");
    }
}
