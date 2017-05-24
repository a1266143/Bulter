package com.xiaojun.bulter;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaojun on 2017/5/24.
 */

public class Utils {
    /**
     * 获取当前的日期
     * @return
     */
    public static String getDate(String pattern){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * dp转px
     * @param context 上下文对象
     * @param dpValue dp值
     * @return 返回像素值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param context 上下文对象
     * @param pxValue 像素值
     * @return 返回dp值
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
