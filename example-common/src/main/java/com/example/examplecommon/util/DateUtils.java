package com.example.examplecommon.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date addMinutes(Date date, int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,minutes);
        return date;
    }

    public static LocalDateTime addMinutes(LocalDateTime date,long minutes){
        date = date.plus(minutes, ChronoUnit.MONTHS);
        return date;
    }

    public static String dateToStr(LocalDateTime date){
        if(date == null ){
            date = LocalDateTime.now();
        }
        String dateStr = date.format(formatter);
        return dateStr;
    }
    
    public static void main(String[] args){
        System.out.println(dateToStr(null));
    }
}
