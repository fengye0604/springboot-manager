package com.example.exampleapollo.utils.codehelper;

/**
 * 工具
 *
 * @author ljgLiu
 * @date 2019-11-27 18:03
 */
public class CodingUtil {
    /**
     * 获取代码生成路径
     *
     * @return
     */
    public static String getSourcePath() {
        // 获取当前项目名称
        String path = CodingGenerator.class.getResource("/").getPath();
        String[] items = path.split("/");
        String projectName = items[items.length - 3];
        // 生成代码路径
        String userDir = System.getProperty("user.dir");

        String sourcePath = userDir + "/" + projectName + "/src/main/java";
        System.out.println("代码生成路径:" + sourcePath);
        return sourcePath;
    }
}
