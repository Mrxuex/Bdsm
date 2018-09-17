package com.example.zimuquan.circleofletters.modle.commom;

/**
 * Created by EDZ on 2018/9/17.
 */

import android.os.Environment;

import okhttp3.Cookie;


/**
 * 常量
 */
public class Const {
    public final static boolean isShowCamera = false;

    //----------------------------------------网络配置----------------------------------------------

   // public static String SVIP = "118.212.137.131";

/*    public static void setSVIP(boolean isCN) {
        if (isCN) {
            SVIP = "118.212.137.131"; //国内服务器IP  120.76.28.207
        } else {
            SVIP = "107.150.106.203";//国外服务器IP
        }
    }*/
    //----------------------------------------chenzy----------------------------------------------
    /**
     * 日志识别字符
     */
    public final static String TAG = "bdsm_log";
    /**
     * 用户信息
     */
    public final static String USER = "User_Info";
    public final static String PUSH = "push_";//推送字符
    public final static String LAST_USE_NAME = "LAST_USE_NAME"; //用户登录账号

    /**
     * 其他界面调到mainactivity的标示符
     */
    public final static String MA_FLAG = "mainactivityTag";


    /**
     * 根目录路径*
     */
    public static final String PATH = Environment.getExternalStorageDirectory().getPath();
    //public static final String TEMP = "temp";//温度
    //public static final String HUMI = "humi";//湿度
    //----------------------------------------chenzy----------------------------------------------
    /**
     * APPKEY:产品识别代码*
     */
   // public final static String APPKEY = "90000";
    /**
     * APP应用市场渠道*
     */
    public static String APPSTORE;
    /**
     * 手机识别代码*
     */
    //public static String PHONEDID = "";
    public static String DEVICE_ID = "";
    /**
     * 用户手机号码*
     */
    public static String USERPHONENUMBER = "0";
    /**
     * 页面显示条数*
     */
    public static final int PAGESIZE = 20;
    /**
     * android类型*
     */
    public static String ANDROID = "android";
    /**
     * Server类型*
     */
    public static String SERVER = "server";
    /**
     * gateWay类型*
     */
    public static String GATEWAY = "gateway";
    /**
     * tcp ip*
     */
    public static String TCP_IP = "";

    /**
     * 网络状态类型*
     */
    public static String netType = "phone_mobile_111";

    public static Cookie COOKIE = null;
    public static String SIGN = null;
    public static String TIMESTAMP = null;

    /**
     * 刷新头像*
     */
    public static final String REFRESH_IMGPATH = "REFRESH_IMGPATH";
    /**
     * 更新用户数据*
     */
    public static final String UPDATE_USER_DATA = "UPDATE_USER_DATA";
    /**
     * 通知广播*
     */
    public static final String SCENE_NOTI = "SCENE_NOTI";

    public static final String SPKEY_ID = "SPKEY_ID";
    public static final String SPKEY_USERNAME = "SPKEY_USERNAME";
    public static final String SPKEY_PHONE = "SPKEY_PHONE";
    public static final String SPKEY_PASSWORD = "SPKEY_PASSWORD";
    public static final String SPKEY_MOBILEPHONE = "SPKEY_MOBILEPHONE";
    public static final String SPKEY_EMAIL = "SPKEY_EMAIL";
    public static final String SPKEY_SYSTEMCODE = "SPKEY_NICKNAME";
    public static final String SPKEY_CREATEDATE = "SPKEY_CREATEDATE";
    public static final String SPKEY_UPDATEDATE = "SPKEY_UPDATEDATE";
    public static final String SPKEY_STATUS = "SPKEY_STATUS";
    public static final String SPKEY_IMGPATH = "SPKEY_IMGPATH";
    public static final String SPKEY_GATEWAYID = "SPKEY_GATEWAYID";
    public static final String SPKEY_GATEWAYIP = "SPKEY_GATEWAYIP";
    public static final String SPKEY_SSID = "SPKEY_SSID";
    public static final String SPKEY_TOKEN = "SPKEY_TOKEN";

    /**
     * WIFI放大功能开关
     */
    public static final String SPKEY_WIFI = "SPKEY_WIFI";

    public static final byte[] SEPARATOR = {(byte) 0xFE, (byte) 0x5C, (byte) 0xFE, (byte) 0x5C};

    /**
     * 图片缓存路径*
     */
    public static final String IMAGECACHEPATH =
            Environment.getExternalStorageDirectory().getPath()
                    + "/bsdm/palmwifi/imagecache";

    /**
     * SharedPreferences 名称*
     */
    public static final String SPNAME = "bdsm_sp_info";
    /**
     * 错误日志保存路径*
     */
    public static final String ERRORLOGPATH =
            Environment.getExternalStorageDirectory().getPath()
                    + "/bdsm/";
    /**
     * 更新apk下载路径*
     */
    public static final String UPDATEAPKDOWNLOADPATH =
            Environment.getExternalStorageDirectory().getPath()
                    + "/bdsm/";

    public static final String MallUrl = "productAction_selectAllProduct";
    /**
     * 网络连接失败提示*
     */
    public static final int NETWORKERRORNUM = 0;
    /**
     * DATA层数据获取成功*
     */
    public static final int GETDATASUCCESS = 1;
    /**
     * 登录、注册 非法提示*
     */
    public static final int EDITCHECKERROR = 6;


    public static String ssid = null;
    /**
     * 是否是中文版
     */
    public static final String IS_CN = "is_cn";

    /**
     * 第一次进入
     */
    public static final String IS_NO_FIRST = "is_no_frist";

    /**
     * 用户账号保存
     */
    public static final String USER_ACCOUNT = "user_account";

}
