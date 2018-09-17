package com.example.zimuquan.circleofletters.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EDZ on 2018/9/17.
 */

public class StringUtils {

    /***
     * 要检查的字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 验证邮箱(保存功能)
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 判断是否是手机号码
     *
     * @param mobile
     * @return
     */
    public static boolean checkPhone(String mobile) {
        boolean flag = false;
        Pattern p = Pattern.compile("^0?(13[0-9]|15[0-9]|18[0-9]|14[57]|17[067])[0-9]{8}$");
        Matcher matcher = p.matcher(mobile);
        flag = matcher.matches();
        return flag;
    }


}
