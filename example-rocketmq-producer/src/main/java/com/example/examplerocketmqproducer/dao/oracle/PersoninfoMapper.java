package com.example.examplerocketmqproducer.dao.oracle;

import com.example.examplerocketmqproducer.bean.Personinfo;

public interface PersoninfoMapper {
    int deleteByPrimaryKey(String oppid);

    int insert(Personinfo record);

    int insertSelective(Personinfo record);

    Personinfo selectByPrimaryKey(String oppid);

    int updateByPrimaryKeySelective(Personinfo record);

    int updateByPrimaryKey(Personinfo record);
}