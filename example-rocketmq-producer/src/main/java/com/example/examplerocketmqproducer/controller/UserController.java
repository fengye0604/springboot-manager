package com.example.examplerocketmqproducer.controller;

import com.example.examplecommon.model.ResultBean;
import com.example.examplecommon.util.JsonUtil;
import com.example.examplerocketmqproducer.bean.UserBean;
import com.example.examplerocketmqproducer.config.JmsConfig;
import com.example.examplerocketmqproducer.config.Producer;
import com.example.examplerocketmqproducer.dao.oracle.OracleUserBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
public class UserController {
    @Autowired
    Producer producer;
    @Autowired
    OracleUserBeanMapper oracleUserBeanMapper;

    @RequestMapping(value = "/user")
    public ResultBean testUser() throws  Exception{
        List<Long> list = new ArrayList<Long>();
        list.add(5789L);
        list.add(5791L);
        list.add(5793L);
        list.add(5795L);
        list.add(5797L);
        list.add(5799L);
        list.add(5801L);
        list.add(5803L);
        list.add(5805L);
        list.add(5807L);
        list.add(5809L);
        list.add(5811L);
        list.add(5813L);
        list.add(5815L);
        list.add(5817L);
        list.add(5819L);
        list.add(5821L);
        list.add(5823L);
        list.add(5825L);
        list.add(5827L);
        list.add(5829L);
        list.add(5831L);
        list.add(5833L);



        List<UserBean> dataList = new ArrayList<UserBean>();
        ResultBean resultBean = new ResultBean();
        for ( Long e : list ) {
            UserBean userBean =  oracleUserBeanMapper.selectByPrimaryKey(e);
            String meaageStr = JsonUtil.jsonToString(userBean);
            Message message = new Message(JmsConfig.TOPIC, "testtag", meaageStr.getBytes());
            SendResult sendResult = producer.getProducer().send(message);
            log.info("callback输出生产者信息={}",sendResult);

            dataList.add(userBean);
        }

        resultBean.setData(list);
        return resultBean;
    }
}
