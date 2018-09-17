package com.example.zimuquan.circleofletters.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.multidex.MultiDex;

import com.example.zimuquan.circleofletters.http.CacheInterceptor;
import com.example.zimuquan.circleofletters.modle.UserInfo;
import com.example.zimuquan.circleofletters.modle.commom.Const;
import com.example.zimuquan.circleofletters.utils.SPUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import static okhttp3.internal.Internal.instance;

/**
 * Created by EDZ on 2018/9/17.
 */

public class BdsM extends BaseApplication {

    public static Boolean isResume = false;//判断回到主界面，是否要刷新数据
    public static String NETSTATE = "wifi";//网络状态
    private static BdsM instance;
    public Activity activity;
    public static UserInfo USER = null;



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MultiDex.install(this);
      //  USER = new SPUtil(this).getUserInfo();
        initImageLoader();
    }


    //单实例appcation
    public static BdsM getInstance() {
        if (instance == null) {
            instance = new BdsM();
        }
        return instance;
    }


    /**
     * 初始化ImageLoader
     */
    private void initImageLoader() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), Const.IMAGECACHEPATH);
        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration
                        .Builder(getApplicationContext())
                        .threadPoolSize(3)
                        .writeDebugLogs() //打印log信息
                        .discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径
                        .build();
        ImageLoader.getInstance().init(config);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


    /**
     * 检查网络是否连接
     */
    public static boolean checkNet() {
        ConnectivityManager connManager = (ConnectivityManager) instance.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null) {
            NetworkInfo net = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (net != null) {
                NetworkInfo.State state = net.getState();
                if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                    NETSTATE = "mobile";
                    return true;
                }
            }
            NetworkInfo net2 = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (net2 != null) {
                NetworkInfo.State state = net2.getState();
                if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                    NETSTATE = "wifi";
                    return true;
                }
            }
        }
        return false;
    }
}
