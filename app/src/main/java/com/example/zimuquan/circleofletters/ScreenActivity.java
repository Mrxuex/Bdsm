package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zimuquan.circleofletters.base.BaseActivity;

/**
 * Created by EDZ on 2018/9/12.
 */

public class ScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.screean_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
