package com.xiaojun.bulter.yyUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Set;

/**
 * SharedPreferences工具类
 * Created by xiaojun on 2017/11/22.
 */

public class SpUtils {

    private static SpUtils spUtils;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    private SpUtils(Context context, String spName) {
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
    static SpUtils getInstance(Context context, String spName) {
        if (spUtils == null)
            spUtils = new SpUtils(context, spName);
        return spUtils;
    }

    /*public static Object get(String key, Object defaultValue) {
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
    }*/

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


    public static <T> T get(String key, Class<T> clazz) {
        if (null == sp) {
            return null;
        }
        if ((String.class).equals(clazz)) {
            return (T) sp.getString(key, null);
        } else if ((Integer.class).equals(clazz)) {
            return (T) Integer.valueOf(sp.getInt(key, Integer.MIN_VALUE));
        } else if ((Float.class).equals(clazz)) {
            return (T) Float.valueOf(sp.getFloat(key, Integer.MIN_VALUE));
        } else if ((Long.class).equals(clazz)) {
            return (T) Long.valueOf(sp.getLong(key, Integer.MIN_VALUE));
        } else if ((Boolean.class).equals(clazz)) {
            return (T) Boolean.valueOf(sp.getBoolean(key, false));
        } else if ((Set.class).equals(clazz)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                return (T) sp.getStringSet(key, null);
            } else {
                System.out.println(Build.VERSION.SDK_INT + "is to low,get data failed");
            }
        }
        return null;
    }
}
