package com.example.elasticjob.test;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

public class JobTest {

        public static void main(String[] args) {
            new JobScheduler(createRegistryCenter(), createJobConfiguration()).init();
        }

        private static CoordinatorRegistryCenter createRegistryCenter() {
            CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                    new ZookeeperConfiguration("123.57.91.202:2182,123.57.91.202:2183,123.57.91.202:2184",
                    "elastic-job-demo"));
            regCenter.init();
            return regCenter;
        }

        private static LiteJobConfiguration createJobConfiguration(){
            // 创建作业配置
            // 定义作业核心配置
            JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("myElasticJob",
                    "0/15 * * * * ?",
                    10).build();
            // 定义simple类型配置
            SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig,
                    MyElasticJob.class.getCanonicalName());
            // 定义Lite作业根配置
            LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
            return simpleJobRootConfig;
        }

}
