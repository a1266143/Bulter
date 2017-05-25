package com.xiaojun.bulter;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;

/**
 * 网络请求工具类
 * Created by xiaojun on 2017/5/25.
 */

public class NetUtils {
    /**
     * Get请求
     * @param url
     * @param params
     */
    public static void doGet(String url, Map<String,String> params, final NetUtilsCallback callback){
        OkHttpUtils.get().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.getNetError();
            }

            @Override
            public void onResponse(final String response, int id) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        callback.getData(response);
                    }
                }).start();
            }
        });

    }

    /**
     * doPost请求
     * @param url
     * @param params
     * @param callback
     */
    public static void doPost(String url,Map<String,String> params,final NetUtilsCallback callback){
        OkHttpUtils.post().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.getNetError();
            }

            @Override
            public void onResponse(final String response, int id) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        callback.getData(response);
                    }
                }).start();
            }
        });
    }

    public interface NetUtilsCallback{
        //获取到数据
        void getData(String data);
        //网络错误
        void getNetError();
    }
}
