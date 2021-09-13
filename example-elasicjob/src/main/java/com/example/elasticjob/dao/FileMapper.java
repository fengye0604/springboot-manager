package com.example.elasticjob.dao;

import com.example.elasticjob.entity.FileCustom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {
    @Select("select * from t_file where type = #{fileType} and backedUp = 0 limit 0, #{count}")
    public List<FileCustom> fetchUnBackupFiles(String fileType, Integer count);
}
