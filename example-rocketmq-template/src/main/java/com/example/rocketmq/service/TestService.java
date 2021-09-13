package com.example.rocketmq.service;

import com.example.examplecommon.model.ResultBean;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public ResultBean test(String messageStr){
        ResultBean resultBean = new ResultBean();
//        Message message = new Message("TopicTest", "testtag", messageStr.getBytes());
//        rocketMQTemplate.send((org.springframework.messaging.Message<String>) message);
        rocketMQTemplate.send("TopicTest", MessageBuilder.withPayload(messageStr+"测试数据").build());


        resultBean.setData(messageStr);
        return  resultBean;
    }
}
