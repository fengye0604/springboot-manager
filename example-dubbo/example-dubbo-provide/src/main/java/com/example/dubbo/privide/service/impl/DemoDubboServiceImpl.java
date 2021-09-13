package com.example.dubbo.privide.service.impl;

import com.example.dubblo.service.DemoDubboService;
import org.apache.dubbo.config.annotation.Service;


@Service
public class DemoDubboServiceImpl implements DemoDubboService {
    @Override
    public String showMsg(String str) {
        return "Hello Dubbo "+str;
    }
}