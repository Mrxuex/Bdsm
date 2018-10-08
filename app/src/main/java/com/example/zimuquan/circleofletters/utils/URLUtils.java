package com.example.zimuquan.circleofletters.utils;

/**
 * Created by EDZ on 2018/9/17. 0
 * <h2>说明:</h2><br/>
 * URL工具 ：通过URL编号获取对应URL地址
 *
 * @author Amy
 **/
public class URLUtils {

    /**
     * 服务器地址
     */
    public static String SERVERPATH = "http://bdsmapi.bdsmchat.top/api/v2/";


    /**
     * URL-GET
     */

    /***************************** visitor **********************************/
    /*游客首页*/
    public static String TouristsHomepage = SERVERPATH + "visitor/home?sex=";
    /*游客查看用户主页*/
    public static String TouristsUserID = SERVERPATH + "visitor/homepage?h_user_id=";
    /*游客查看用户动态*/
    public static String TouristsUserHomepage = SERVERPATH + "visitor/dynamics_list?other_user_id=";


    /*****************************index**********************************/
    /* 获取基本配置*/
    public static String TouristuUser = SERVERPATH + "config/app";
    /*首页接口*/
    public static String TouristsHome = SERVERPATH + "index/home?name=recommend";
    /*获取首页搜索条件接口*/
    public static String TouristsSearchCriteria = SERVERPATH + "index/search_condition";


    /***************************** pay **********************************/
    /*支付*/
    public static String TouristsPay = SERVERPATH + "{{url}}{{pay}}/{{payType}}?type=1";
    /* 用户信息页面*/
    public static String TouristsUserAll = SERVERPATH + "visitor/homepage?h_user_id=21";

    /*访问记录*/
    public static String FangWenJiLu = SERVERPATH + "user/getRecentVisitor";
    /*im通讯中断*/
    public static String ImJiLu = SERVERPATH + "user/checkCanInitiateChat?to_user_id=136";

    /***************************** user **********************************/

    /**
     * URL-POST
     */
    /*用戶手機驗證碼登錄*/
    public static String TouristsUserLogin = SERVERPATH + "user/loginBySmsCode";
    /*获取验证码*/
    public static String TouristuUserLoginCode = SERVERPATH + "register/sendSmsCode?";
    /*验证手机号*/
    public static String TouristuUserLoginPhone = SERVERPATH + "register/isFreePhone?";

    /*投诉*/
    public static String TouSuJuBao = SERVERPATH + "user/reported?content=hahahah&come_way=15757141767&target_user_id=12009&img_list=";
    /*意见反馈*/
    public static String YiJianFanKui = SERVERPATH + "user/feedback?content=hahahah&come_way=15757141767";


    /**
     * URL-put
     */
    private static String ChangeUserMess = SERVERPATH + "user/updateNotes?to_user_id=136&remark=哈哈";

    /**
     * URL-Methods
     */
    /*获取游客首页信息*/
    public static String getTouristsHomepage() {
        return TouristsHomepage;
    }

    /* 手机号与验证登陆*/
    public static String login(String phone, String code) {
        return TouristsUserLogin + "phone=" + phone + "&" + "sms_code=" + code;
    }

    /* 根据手机号获取验证码*/
    public static String loginCode(String phone) {
        return TouristuUserLoginCode + "phone=" + phone + "&action=login";
    }

    /*验证手机号*/
    public static String loginPhone(String phone) {
        return TouristuUserLoginCode + "phone=" + phone;
    }

}
