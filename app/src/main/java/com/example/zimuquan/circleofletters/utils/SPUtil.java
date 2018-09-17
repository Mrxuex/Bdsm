package com.example.zimuquan.circleofletters.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.zimuquan.circleofletters.base.BdsM;
import com.example.zimuquan.circleofletters.modle.UserInfo;
import com.example.zimuquan.circleofletters.modle.commom.Const;

/**
 * SharedPreferences 轻量级存储工具
 **/
public class SPUtil {
    public static SPUtil sp;
    private SharedPreferences m_wsp = null;
    private Editor m_weditor;

    /**
     * SPUtil
     *
     * @return SharedPreferences对象
     **/
    public static SPUtil Instance() {
        if (sp == null) {
            sp = new SPUtil(BdsM.getInstance());
        }
        return sp;
    }

    public SPUtil(Context context) {
        super();
        m_wsp = context.getSharedPreferences(Const.SPNAME, Context.MODE_PRIVATE);
        m_weditor = m_wsp.edit();
    }

    /**
     * 保存String类型数据
     */
    public boolean save(String key, String value) {
        m_weditor.putString(key, value);
        return m_weditor.commit();
    }

    /**
     * 取出String类型数据 默认值为空
     */
    public String read(String key) {
        String str = null;
        str = m_wsp.getString(key, "");
        return str;
    }

    /**
     * 取出String类型数据 可设默认值
     */
    public String read(String key, String def) {
        String str = null;
        str = m_wsp.getString(key, def);
        return str;
    }

    /**
     * 保存Int类型数据
     */
    public boolean saveInt(String key, int value) {
        m_weditor.putInt(key, value);
        return m_weditor.commit();
    }

    /**
     * 取出Integer类型数据 ,默认值为0
     */
    public Integer readInt(String key) {
        int str;
        str = m_wsp.getInt(key, 0);
        return str;
    }

    /**
     * 取出Integer类型数据 ,可设默认值
     */
    public Integer readInt(String key, int def) {
        int str;
        str = m_wsp.getInt(key, def);
        return str;
    }

    /**
     * 删除数据
     */
    public boolean remove(String key) {
        m_weditor.remove(key);
        return m_weditor.commit();
    }

    /**
     * 保存Boolean类型数据
     */
    public boolean saveBoolean(String key, boolean value) {
        m_weditor.putBoolean(key, value);
        return m_weditor.commit();
    }

    /**
     * 取出Boolean类型数据
     */
    public boolean readBoolean(String key) {
        boolean bool;
        bool = m_wsp.getBoolean(key, false);
        return bool;
    }

    public UserInfo getUserInfo() {

        return (UserInfo) JsonUtil.jsonToBean(read(Const.USER), UserInfo.class);
    }

    public void saveUserInfo(UserInfo userInfo) {
        save(Const.USER, JsonUtil.objectToJson(userInfo));
    }

    /**
     * 登录需要保存的数据
     */
    public void login(UserInfo userInfo) {
        if (userInfo != null) {
            m_weditor.putString(Const.USER, JsonUtil.objectToJson(userInfo));//保存用户数据
            String lastName = read(Const.LAST_USE_NAME);
           /* if (StringUtil.isEmpty(userInfo.getGatewayId()) || !StringUtil.isEquals(lastName, userInfo.getUsername())) {
                m_weditor.remove(Const.GWINFO);//清除网关数据
                m_weditor.remove(Const.DVINFO);//清除设备信息
                m_weditor.remove(Const.PUSH);//清除用户推送字符信息
            }*/
          //  m_weditor.putString(Const.LAST_USE_NAME, userInfo.getUsername());
            m_weditor.commit();
        }
    }

    /**
     * 退出需要清理的数据
     */
    public void logout() {
        BdsM.USER = null;
        Const.SIGN = null;
        m_weditor.remove(Const.USER);//清除用户信息
        m_weditor.remove(Const.PUSH);//清除用户推送字符信息
        m_weditor.commit();
    }
/*
    *//**
     * 绑定成功
     *//*
    public void Bind(UserInfo userInfo) {
        m_weditor.putString(Const.USER, JsonUtil.objectToJson(userInfo));//保存用户数据
        //m_weditor.putString(Const.LAST_USE_NAME, userInfo.getUsername());
        // m_weditor.remove(Const.USER);//清除用户信息
        m_weditor.remove(Const.GWINFO);//清除网关数据
        m_weditor.remove(Const.DVINFO);//清除设备信息
        m_weditor.remove(Const.PUSH);//清除用户推送字符信息
        m_weditor.commit();
    }*/

  /*  *//**
     * 解除绑定
     *//*
    public void unBind() {
        // m_weditor.remove(Const.USER);//清除用户信息
        m_weditor.remove(Const.GWINFO);//清除网关数据
        m_weditor.remove(Const.DVINFO);//清除设备信息
        m_weditor.remove(Const.PUSH);//清除用户推送字符信息
        m_weditor.commit();
        MinaManager.getInstance().destroy();//退出TCP
    }*/
}

