package com.liuenci.vblog.utils;

import com.google.gson.Gson;

/**
 * json转换工具
 * @author liuenci
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJsonString(Object object){
      return object==null?null:gson.toJson(object);
    }
}
