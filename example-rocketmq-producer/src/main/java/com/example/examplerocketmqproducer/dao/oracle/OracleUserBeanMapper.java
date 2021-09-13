package com.example.examplerocketmqproducer.dao.oracle;


import com.example.examplerocketmqproducer.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleUserBeanMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}