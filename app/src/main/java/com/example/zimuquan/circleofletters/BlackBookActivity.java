package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/13.
 */

public class BlackBookActivity extends BaseActivity {
    /* title_头部*/
    @BindView(R.id.backbtnlay)
    ImageView backbtnlay;
    @BindView(R.id.toptitleText)
    TextView titleText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_set_blackbook_layout;
    }

    @Override
    public void initView() {
        titleText.setText("黑名单");
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.backbtnlay)
    public void click(View view) {
        switch (view.getId()) {

            case R.id.backbtnlay:
                finish();
                break;


        }
    }
}