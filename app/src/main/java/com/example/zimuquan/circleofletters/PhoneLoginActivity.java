package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.ui.view.OnclickButton;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/10.
 */

public class PhoneLoginActivity extends BaseActivity {

    @BindView(R.id.login_btn)
    OnclickButton onclickButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);//设置是否显示标题栏
        setState(true);//设置是否显示状态栏

        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.phone_login_layout;
    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.login_btn)
    public void click(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                startActivity(new Intent(PhoneLoginActivity.this,MainActivity.class));
        }
        // startLoginActivity();
    }

    @Override
    public void initData() {

    }
}
