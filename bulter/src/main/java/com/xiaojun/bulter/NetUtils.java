package com.xiaojun.bulter;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络请求工具类
 * Created by xiaojun on 2017/5/25.
 */

public class NetUtils {
    /**
     * Get请求
     *
     * @param url
     * @param params
     */
    public static <T> void doGet(String url, Map<String, String> params, final NetUtilsCallback<T> callback, final T beanType) {
        OkHttpUtils.get().url(url).params(params).build().execute(new Callback<T>() {
            @Override
            public T parseNetworkResponse(Response response, int id) throws Exception {
                String string = response.body().string();
                try {
                    T t = (T) new Gson().fromJson(string, beanType.getClass());
                    return t;
                } catch (Exception e) {
                    return null;
                }


            }

            @Override
            public void onError(Call call, Exception e, int id) {
                if (call == null) return;
                callback.getNetError();
            }

            @Override
            public void onResponse(T response, int id) {
                callback.getData(response);
            }
        });

    }

    /**
     * doPost请求
     *
     * @param url
     * @param params
     * @param callback
     */
    public static <T> void doPost(String url, Map<String, String> params, final NetUtilsCallback<T> callback, final T beanType) {

        OkHttpUtils.post().url(url).params(params).build().execute(new Callback<T>() {
            @Override
            public T parseNetworkResponse(Response response, int id) throws Exception {
                String string = response.body().string();
                try {
                    T t = (T) new Gson().fromJson(string, beanType.getClass());
                    return t;
                } catch (Exception e) {
                    return null;
                }

            }

            @Override
            public void onError(Call call, Exception e, int id) {
                if (call == null) return;
                callback.getNetError();
            }

            @Override
            public void onResponse(T response, int id) {
                callback.getData(response);
            }
        });
    }

    public interface NetUtilsCallback<T> {
        //获取到数据
        void getData(T data);

        //网络错误
        void getNetError();
    }
}
