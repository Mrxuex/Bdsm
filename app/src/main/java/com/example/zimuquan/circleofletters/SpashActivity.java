package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.example.zimuquan.circleofletters.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/10.
 */

public class SpashActivity extends BaseActivity {

    @BindView(R.id.fl_guide_countdown_phone)
    FrameLayout  view_phone;
    @BindView(R.id.fl_guide_wechat)
    FrameLayout view_wechat;
    @BindView(R.id.fl_guide_guanguan)
    FrameLayout view_guangguan;
    @BindView(R.id.fl_guide_icah)
    FrameLayout view_icah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);//设置是否显示标题栏
        setState(false);//设置是否显示状态栏

        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.shash_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.fl_guide_countdown_phone)
    public void click(View view) {
        switch (view.getId()){
            case R.id.fl_guide_countdown_phone:
                startActivity(new Intent(SpashActivity.this,PhoneLoginActivity.class));
        }
       // startLoginActivity();
    }
}
