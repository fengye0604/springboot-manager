package com.example.job.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.example.job.util.DateUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.elastic.job
 * @author:yanggaoli
 * @createTime:2021/7/18 22:21
 * @version:1.0
 */
@Slf4j
@Component
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("MySimpleJob的execute方法执行了，执行时间{},总分片数{},当前分片数{},分片参数{}",
                DateUtils.dateToString(new Date()),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter()
        );

    }
}
