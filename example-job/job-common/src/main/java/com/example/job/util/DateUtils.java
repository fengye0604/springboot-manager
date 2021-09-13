package com.example.job.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.timer.utils
 * @author:yanggaoli
 * @createTime:2021/7/18 15:12
 * @version:1.0
 */
public class DateUtils {
    public static final SimpleDateFormat DATA_TIME_SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    public static String dateToString(Date date){
        if(date == null ){
            date = new Date();
        }
        return DATA_TIME_SDF.format(date);
    }
}
