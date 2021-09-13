package com.example.examplemultdatasource.controller;

//import com.example.examplecommon.model.ResultBean;
import com.example.examplecommon.model.ResultBean;
import com.example.examplemultdatasource.bean.UserBean;
import com.example.examplemultdatasource.dao.mysql.UserBeanMapper;
import com.example.examplemultdatasource.dao.oracle.OracleUserBeanMapper;
//import common.model.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    OracleUserBeanMapper oracleUserBeanMapper;
    @Autowired
    UserBeanMapper UserBeanMapper;
    @RequestMapping(value = "/user")
//    public Object testUser(){
////        ResultBean resultBean = new ResultBean();
//        UserBean userBean =  oracleUserBeanMapper.selectByPrimaryKey(5787L);
//        UserBean userBean1 = UserBeanMapper.selectByPrimaryKey(123L);
//        List<UserBean> list = new ArrayList<UserBean>();
//        list.add(userBean);
//        list.add(userBean1);
////        resultBean.setData(list);
//        return list;
//    }

    public ResultBean testUser(){
        ResultBean resultBean = new ResultBean();
        UserBean userBean =  oracleUserBeanMapper.selectByPrimaryKey(5787L);
        UserBean userBean1 = UserBeanMapper.selectByPrimaryKey(123L);
        List<UserBean> list = new ArrayList<UserBean>();
        list.add(userBean);
        list.add(userBean1);
        resultBean.setData(list);
        return resultBean;
    }
    /**/
}
