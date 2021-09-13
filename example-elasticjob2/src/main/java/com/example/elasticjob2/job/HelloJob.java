package com.example.elasticjob2.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.example.elasticjob2.annotation.TaskJobSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@TaskJobSign(cron = "0/5 * * * * ?",jobName = "Hello-Job")
public class HelloJob implements SimpleJob {
    private static final Logger LOG = LoggerFactory.getLogger(HelloJob.class.getName()) ;
    @Override
    public void execute(ShardingContext shardingContext) {
        LOG.info("当前线程: "+Thread.currentThread().getId());
        LOG.info("任务分片："+shardingContext.getShardingTotalCount());
        LOG.info("当前分片："+shardingContext.getShardingItem());
        LOG.info("分片参数："+shardingContext.getShardingParameter());
        LOG.info("任务参数："+shardingContext.getJobParameter());
    }
}