package com.example.examplerocketmq.controller;


//import com.example.examplecommon.util.JsonUtil;
import com.example.examplemultdatasource.bean.UserBean;

import com.example.examplemultdatasource.dao.oracle.OracleUserBeanMapper;
import com.example.examplerocketmq.config.JmsConfig;
import com.example.examplerocketmq.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private Producer producer;

    @Autowired
    OracleUserBeanMapper oracleUserBeanMapperImpl;


    private List<String> mesList;
    private List<Long> userIdList;

    /**
     * 初始化消息
     */
    public Controller() {
        mesList = new ArrayList<>();
        mesList.add("小小");
        mesList.add("爸爸");
        mesList.add("妈妈");
        mesList.add("爷爷");
        mesList.add("奶奶");
        System.out.println("ffadshfjadsfa打法撒旦解放路卡士大夫大三级分类加上点击分类！");

        userIdList = new ArrayList<Long>();
        userIdList.add(5787L);
        userIdList.add(5789L);
        userIdList.add(5791L);
        userIdList.add(5795L);
        userIdList.add(5797L);
        userIdList.add(5807L);
    }

    @RequestMapping("/text/rocketmq")
    public Object callback() throws Exception {
        for (Long s : userIdList) {
//            UserBean userBean = oracleUserBeanMapper.selectByPrimaryKey(s);
            UserBean userBean = oracleUserBeanMapperImpl.selectByPrimaryKey(s);
//            String meaageStr = JsonUtil.jsonToString(userBean);
            //创建生产信息
//            Message message = new Message(JmsConfig.TOPIC, "testtag", meaageStr.getBytes());
            //发送
//            SendResult sendResult = producer.getProducer().send(message);


//            log.info("callback输出生产者信息={}",sendResult);
        }

        //总共发送五次消息
//        for (String s : mesList) {
//            //创建生产信息
//            Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
//            //发送
//            SendResult sendResult = producer.getProducer().send(message);
//
//
//            log.info("callback输出生产者信息={}",sendResult);
//        }
        return "成功";
    } 
}