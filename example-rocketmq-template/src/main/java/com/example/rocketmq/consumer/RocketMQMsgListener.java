package com.example.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(
        topic = "TopicTest",
        selectorExpression="*",
        consumerGroup = "test_consumer"
)
public class RocketMQMsgListener implements RocketMQListener<MessageExt> {

 
    @Override
    public void onMessage(MessageExt message) {
        byte[] body = message.getBody();
        String msg = new String(body);
        log.info("接收到消息：{}", msg);
    }
 
}