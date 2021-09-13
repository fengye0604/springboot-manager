package com.example.elasticsearchdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName = "item", shards = 1, replicas = 0)
public class ContentInfo implements Serializable {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String contentType;

    @Field(type = FieldType.Keyword)
    private String keyword;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String klContent;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Keyword)
    private String isDel;

    @Field(type = FieldType.Date)
    private Date createTime;
}
