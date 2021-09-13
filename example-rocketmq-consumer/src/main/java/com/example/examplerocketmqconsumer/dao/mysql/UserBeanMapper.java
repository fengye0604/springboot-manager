package com.example.examplerocketmqconsumer.dao.mysql;

import com.example.examplerocketmqconsumer.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBeanMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}