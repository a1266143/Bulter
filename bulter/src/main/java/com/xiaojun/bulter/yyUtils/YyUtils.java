package com.xiaojun.bulter.yyUtils;

import android.content.Context;

/**
 * 管理初始化所有工具类的类
 * Created by xiaojun on 2017/11/22.
 */
public class YyUtils {

    /**
     *全局初始化所有工具类
     * @param context
     */
    public static void init(Context context){
        SpUtils.getInstance(context,"Config");//初始化SharedPreferences
        CacheUtils.getInstance(context);//初始化缓存工具类
        ScreenUtils.getInstance(context);//初始化屏幕工具类
    }
}
