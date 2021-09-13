package com.example.examplecommon.util;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtil {

    public static String jsonToString(Object param){
       return new Gson().toJson(param);
    }


    public static <T> T parseJsonFromString(String jsonString,Class classz) {
        Gson gson = new Gson();
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonElement parse = parser.parse(jsonString);
        T obj = (T)gson.fromJson(jsonString, classz);
        return obj;
    }

    private static Object parseJsonStringToList(String jsonString) {
        Object o = new Object();
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(jsonString).getAsJsonArray();

        Gson gson = new Gson();
        //加强for循环遍历JsonArray
        for (JsonElement questionAnswerData : jsonArray) {
            //使用GSON，直接转成Bean对象
        }
        return new Object();
    }
}
