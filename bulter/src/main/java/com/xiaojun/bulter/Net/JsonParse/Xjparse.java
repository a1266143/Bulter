package com.xiaojun.bulter.Net.JsonParse;


import com.google.gson.Gson;

/**
 * 负责解析json的类
 * Created by xiaojun on 2017/5/25.
 */

public class Xjparse {

    private Gson gson = new Gson();
    static Xjparse xjparse;
    private Xjparse(){
    }

    /**
     * 单例
     * @return 返回当前类的对象
     */
    public static Xjparse getInstance(){
        if(xjparse == null)
            xjparse = new Xjparse();
        return xjparse;
    }

    /**
     * 解析json
     * @param jsonStr
     * @param object
     * @param <T>
     * @return
     */
    public <T>T parseObject(String jsonStr,Class<T> object){
        try{
            T bean = gson.fromJson(jsonStr,object);
            return bean;
        }catch (Exception e){
            return null;
        }
    }
}
