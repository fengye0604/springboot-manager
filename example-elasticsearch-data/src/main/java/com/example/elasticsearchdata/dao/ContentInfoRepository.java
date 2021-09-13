package com.example.elasticsearchdata.dao;

import com.example.elasticsearchdata.Elasticsearchdata;
import com.example.elasticsearchdata.entity.ContentInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ContentInfoRepository extends ElasticsearchRepository<ContentInfo,String> {
}
