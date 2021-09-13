package com.example.job.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.example.job.elastic.init.MyCommandLineRunner;
import com.example.job.moden.FileCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.elastic.job
 * @author:yanggaoli
 * @createTime:2021/7/18 22:22
 * @version:1.0
 */
@Component
@Slf4j
public class MyDataFlowJob implements DataflowJob<FileCustom> {

    @Override
    public List<FileCustom> fetchData(ShardingContext shardingContext) {

        List<FileCustom> fileCustoms = MyCommandLineRunner.fileCustoms;
        List<FileCustom> collect = fileCustoms.stream()
                .filter((fileCustom) -> {
                    return fileCustom.getType().equals(shardingContext.getShardingParameter());
                }).collect(Collectors.toList());
        log.info("当前的分片参数是{},总共获取到的数据是{}",shardingContext.getShardingParameter(),collect.size());
        return collect;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<FileCustom> list) {
        list.stream().forEach((fileCustom)->{
            log.info("当前的分片参数是{},获取打ode数据是{}",shardingContext.getShardingParameter(),fileCustom.toString());
        });
    }
}
