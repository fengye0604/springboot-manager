package com.example.elasticjob.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob implements SimpleJob {
    
    @Override
    public void execute(ShardingContext context) {
        System.out.println("======总分片数======="+context.getShardingTotalCount());
        System.out.println("======ShardingParameter======="+context.getShardingParameter());
        System.out.println("======JobParameter======="+context.getJobParameter());
        switch (context.getShardingItem()) {
            case 0: 
                // do something by sharding item 0
                System.out.println("分片以============="+0);
                break;
            case 1: 
                // do something by sharding item 1
                System.out.println("分片以============="+1);
                break;
            case 2: 
                // do something by sharding item 2
                System.out.println("分片以============="+2);
                break;
            // case n: ...
        }
    }
}