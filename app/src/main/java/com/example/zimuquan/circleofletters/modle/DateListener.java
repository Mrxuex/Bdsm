package com.example.zimuquan.circleofletters.modle;

/**
 * Created by EDZ on 2018/9/18.
 */


public interface DateListener {
    void setYear(String year);

    void setMonth(String month);

    void setDay(String day);

    void setMouthDate(String year, String month);

    void setYearDate(String year, String month, String day);

}