package com.example.job.elastic.init;

import com.example.job.moden.FileCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    public static List<FileCustom> fileCustoms = new ArrayList<FileCustom>();
    @Override
    public void run(String... args) throws Exception {
        for(int i=1;i<11;i++){
            fileCustoms.add(new FileCustom(String.valueOf(i+10),"文件"+(i+10),"text","content"+ (i+10)));
            fileCustoms.add(new FileCustom(String.valueOf(i+20),"文件"+(i+20),"image","content"+ (i+20)));
            fileCustoms.add(new FileCustom(String.valueOf(i+30),"文件"+(i+30),"radio","content"+ (i+30)));
            fileCustoms.add(new FileCustom(String.valueOf(i+40),"文件"+(i+40),"video","content"+ (i+40)));
        }
        System.out.println("生产测试数据完成");
    }
}