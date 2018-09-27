package com.example.zimuquan.circleofletters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by EDZ on 2018/9/14.
 */

public class MinePersonalityLabelActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.backbtnlay)
    ImageView back;
    @BindView(R.id.toptitleText)
    TextView textView;
    @BindView(R.id.rightlay)
    TextView right;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_personal_lable_layout;
    }


    @Override
    public void initView() {
    textView.setText("个性标签");
        right.setText("保存");
      //  right.setTextColor(Color.R.color.user_color);
        back.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.backbtnlay:
        finish();
        break;
}
    }
}
