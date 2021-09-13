package com.example.examplemultdatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //主数据源配置 ds1数据源
    @Primary
    @Bean(name = "mysqldbDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.mysqldb")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    //主数据源 ds1数据源
    @Primary
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(@Qualifier("mysqldbDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    //第二个ds2数据源配置
    @Bean(name = "oracledbDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.oracledb")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    //第二个ds2数据源
    @Bean("oracleDataSource")
    public DataSource oracleDataSource(@Qualifier("oracledbDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
