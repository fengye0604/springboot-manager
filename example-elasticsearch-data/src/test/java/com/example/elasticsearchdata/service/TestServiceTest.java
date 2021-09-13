package com.example.elasticsearchdata.service;

import com.example.elasticsearchdata.Elasticsearchdata;
import com.example.elasticsearchdata.dao.ContentInfoRepository;
import com.example.elasticsearchdata.entity.ContentInfo;
import org.elasticsearch.client.ElasticsearchClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.Iterator;
import java.util.Optional;


@SpringBootTest(classes = Elasticsearchdata.class)
public class TestServiceTest {
    @Autowired
    TestService testService;

    @Autowired
    ContentInfoRepository contentInfoRepository;

    @Test
    public void test(){
        String test = testService.test();
        System.out.println(test);
    }

/*
        cluster-nodes: 123.57.91.202:9300
      cluster-name: elasticsearch
      */
    @Test
    public void testQuery(){
//        Optional<ContentInfo> contentInfo = contentInfoRepository.findById("pdxq_info_2172");

        Iterable<ContentInfo> contentInfos = contentInfoRepository.findAll();

        Iterator<ContentInfo> iterator = contentInfos.iterator();
        if(iterator.hasNext()){
            iterator.next().getTitle();
        }
    }
}