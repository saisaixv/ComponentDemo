package com.shunyi.cydex.common.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saisai on 2017/6/15.
 */

public class DataParseUtil {

    public static <T> T parseObject(String s,Class<T> tClass){

        return new Gson().fromJson(s,tClass);
    }

    public static <T> ArrayList<T> parseToArrayList(String s,Class<T> tClass){

        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<JsonObject> jsonObjects=new Gson().fromJson(s,type);
        ArrayList<T> arrayList=new ArrayList<>();
        for(JsonObject obj:jsonObjects){
            arrayList.add(new Gson().fromJson(obj,tClass));
        }
        return arrayList;
    }

    public static <T> List<T> parseToList(String json,Class<T[]> clazz){

        T[] array=new Gson().fromJson(json,clazz);
        return Arrays.asList(array);
    }


    public static Object parseXML(String s,Class<?> clazz){

        Log.e("tag","未实现解析xml");
        return null;
    }
}
