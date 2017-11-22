package com.xiaojun.bulter.yyUtils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 屏幕相关工具类
 * Created by xiaojun on 2017/11/22.
 */

public class ScreenUtils {

    private static ScreenUtils screenUtils;
    private static Context context;
    private ScreenUtils(Context context){
        ScreenUtils.context = context;
    }

    public static ScreenUtils getInstance(Context context){
        if (screenUtils == null)
            screenUtils = new ScreenUtils(context);
        return screenUtils;
    }

    /**
     * 获取屏幕宽度
     * @return
     */
    public static int getScreenWidth(){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getScreenHeight(){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        return height;
    }

    /**
     * dp转px
     * @param dpValue dp值
     * @return 返回像素值
     */
    public static int dp2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param pxValue 像素值
     * @return 返回dp值
     */
    public static int px2dp(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
