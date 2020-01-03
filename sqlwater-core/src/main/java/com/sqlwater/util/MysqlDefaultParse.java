package com.sqlwater.util;

/**
 * @Date 2020/1/3 17:41
 * @Version 1.0
 */
public class MysqlDefaultParse {
    String urlCase = "jdbc:mysql://49.234.7.155:3306/fwh?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static String getIp(String url){
        String[] strings = url.split(":|=|&|/|\\?");
        return strings[4];
    }
    public static String getPort(String url){
        String[] strings = url.split(":|=|&|/|\\?");
        return strings[5];
    }
    public static String getDataBaseName(String url){
        String[] strings = url.split(":|=|&|/|\\?");
        return strings[6];
    }
    public static String getDataBaseType(String url){
        String[] strings = url.split(":|=|&|/|\\?");
        return strings[5];
    }
    //TODO 获得连接属性map
}
