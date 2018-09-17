package com.example.zimuquan.circleofletters.base;

import android.app.Application;
import android.content.Context;
import com.example.zimuquan.circleofletters.http.CacheInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Created by David on 2018/10/1.
 */

public class BaseApplication extends Application {

    private static  BaseApplication mApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }



    /**
     * 初始化OKHttp
     */
    public void initOkHttpClient(boolean isLogDisable, String logName,CacheInterceptor cacheInterceptor){

        File cacheFile = new File(getExternalCacheDir(),"httpCache");
        okhttp3.Cache cache = new okhttp3.Cache(cacheFile,1024*1024*50);
        OkHttpClient.Builder builder= new OkHttpClient.Builder();
        if(isLogDisable){
            builder.addInterceptor(new com.zhy.http.okhttp.log.LoggerInterceptor(logName));
        }
        OkHttpClient okHttpClient =builder.addNetworkInterceptor(cacheInterceptor)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000,TimeUnit.MILLISECONDS)
                .readTimeout(10000,TimeUnit.MILLISECONDS)
                .addInterceptor(cacheInterceptor)
                .cache(cache)
                .build();
        com.zhy.http.okhttp.OkHttpUtils.initClient(okHttpClient);
    }


}
