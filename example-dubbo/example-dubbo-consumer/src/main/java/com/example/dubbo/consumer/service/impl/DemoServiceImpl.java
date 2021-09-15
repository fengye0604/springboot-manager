package com.example.dubbo.consumer.service.impl;

import com.example.dubblo.service.DemoDubboService;
import com.example.dubbo.consumer.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService {

    @Reference
    private DemoDubboService demoDubboService;

   @Override
   public String getMsg(String str) {
       return demoDubboService.showMsg(str);
   }
}