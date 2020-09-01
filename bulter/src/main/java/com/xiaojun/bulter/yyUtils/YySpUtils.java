package com.xiaojun.bulter.yyUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences工具类
 * Created by xiaojun on 2017/11/22.
 */

public class YySpUtils {

    private static YySpUtils yySpUtils;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    private YySpUtils(Context context, String spName) {
        sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 获取单例
     *
     * @param context 上下文
     * @param spName  SharedPreferences文件名称
     * @return 返回当前对象
     */
    public static YySpUtils getInstance(Context context, String spName) {
        if (yySpUtils == null)
            yySpUtils = new YySpUtils(context, spName);
        return yySpUtils;
    }

    /**
     * 获取SharedPreference中的对应key的value
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object get(String key, Object defaultValue) {
        if (defaultValue instanceof String)
            return sp.getString(key, (String) defaultValue);
        else if (defaultValue instanceof Boolean)
            return sp.getBoolean(key, (Boolean) defaultValue);
        else if (defaultValue instanceof Integer)
            return sp.getInt(key, (Integer) defaultValue);
        else if (defaultValue instanceof Float)
            return sp.getFloat(key, (Float) defaultValue);
        else if (defaultValue instanceof Long)
            return sp.getLong(key, (Long) defaultValue);
        else
            return null;
    }

    /**
     * 保存key-value到SharedPreference中
     * @param key
     * @param defaultValue
     */
    public static void put(String key, Object defaultValue) {
        if (defaultValue instanceof String)
            editor.putString(key, (String) defaultValue);
        else if (defaultValue instanceof Boolean)
            editor.putBoolean(key, (Boolean) defaultValue);
        else if (defaultValue instanceof Integer)
            editor.putInt(key, (Integer) defaultValue);
        else if (defaultValue instanceof Float)
            editor.putInt(key, (Integer) defaultValue);
        else if (defaultValue instanceof Long)
            editor.putLong(key, (Long) defaultValue);
        editor.apply();
    }

}
