package com.example.exampleapollo.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * MybatisPlus 2.x基础代码生成器
 *
 * @author
 * @date 2019-01-18 15:29
 * -link https://baomidou.gitee.io/mybatis-plus-doc/#/generate-code
 */
public class CodingGenerator {

    public static void main(String[] args) {
        // 生成代码路径
        String sourcePath = System.getProperty("user.dir")+"/example-apollo/src/main/java";
        // 代码包路径
        String parentPackagePath = "com.example.exampleapollo";
        // 涉及表名称
        String[] includeTableNames = new String[]{"user"};

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 指定模板引擎
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/example?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("880604zy");
        autoGenerator.setDataSource(dsc);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // TODO:覆盖已生成的代码
        globalConfig.setFileOverride(true);
        // 生成文件的输出目录
        globalConfig.setOutputDir(sourcePath);
        // @author 注释
        globalConfig.setAuthor("gaoli.yang");
        // 是否打开输出目录
        globalConfig.setOpen(false);
        // 不需要ActiveRecord特性的请改为false
        globalConfig.setActiveRecord(false);
        // 不启用Mapper缓存
        globalConfig.setEnableCache(false);

        // 设置model后缀  %s为表名称的占位符
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseResultMap(true);
        // 实现类后缀名
        globalConfig.setServiceImplName("%sService");
        //TODO: 实体命名规则 2.x代码插件不支持，此处特殊处理
        String entryNameFormat = "%sDO";

        autoGenerator.setGlobalConfig(globalConfig);

        // 代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 是否输出Mapper.xml  templateConfig.setXml(null)
        autoGenerator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
//        strategy.setVersionFieldName()
        // 是否大写命名
        strategy.setCapitalMode(true);

        //TODO: 需要生成的表名称
        strategy.setInclude(includeTableNames);
        // 需要排除生成的表名称
        strategy.setExclude(new String[]{});
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");

        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);

        // 驼峰转连字符 针对@RequestMapping路径
        strategy.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackagePath);
        // 模块路径
        pc.setModuleName(null);
        pc.setMapper("dao");
        pc.setXml("xml");
        autoGenerator.setPackageInfo(pc);

        //***************************************** 以下代码必须顺序执行
        if (StringUtils.isNotBlank(entryNameFormat)) {
            ConfigBuilder config = new ConfigBuilder(autoGenerator.getPackageInfo(),
                    autoGenerator.getDataSource(),
                    autoGenerator.getStrategy(),
                    autoGenerator.getTemplate(),
                    autoGenerator.getGlobalConfig());
            // 表信息
            List<TableInfo> tableInfoList = config.getTableInfoList();
            for (TableInfo tableInfo : tableInfoList) {
                System.out.println(tableInfo.getEntityName());
                //表对应的entity自定义名称
                String entryName = String.format(entryNameFormat, tableInfo.getEntityName());
                tableInfo.setEntityName(autoGenerator.getStrategy(), entryName);
            }
            // 如果存在: 注入自定义配置  injectionConfig.setConfig(config)
            autoGenerator.setConfig(config);
        }
        // 执行生成以下代码必须顺序执行
        autoGenerator.execute();
    }

}
