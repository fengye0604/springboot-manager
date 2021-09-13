package com.example.examplerocketmqproducer.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
public class Producer {
    private String producerGroup = "test_producer";
    private DefaultMQProducer producer;

    public Producer(){
        //示例生产者
        producer = new DefaultMQProducer(producerGroup);
        //不开启vip通道 开通口端口会减2
        producer.setVipChannelEnabled(false);
        //绑定name server
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        start();
    }
    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }
}
  /*
public class Producer {



    @Autowired
    private RocketMQTemplate t;

    public void send() {
        //发送消息
        t.convertAndSend("Topic1:TagA", "Hello world! ");

        //发送spring的Message
        t.send("Topic1:TagA", MessageBuilder.withPayload("Hello world! ").build());

        //发送异步消息
        t.asyncSend("Topic1:TagA", "Hello world!", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });

        //发送顺序消息
        t.syncSendOrderly("Topic1", "98456237,创建", "98456237");
        t.syncSendOrderly("Topic1", "98456237,支付", "98456237");
        t.syncSendOrderly("Topic1", "98456237,完成", "98456237");
    }

}
   */