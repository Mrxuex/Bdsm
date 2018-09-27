package com.example.zimuquan.circleofletters;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by EDZ on 2018/9/14.
 */

public class MineMyDynamicActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.backbtnlay)
    ImageView back;
    @BindView(R.id.toptitleText)
    TextView toptitle;
    @BindView(R.id.rightlay)
    TextView righ_cerame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_mydynamic_layout;
    }

    @Override
    public void initView() {
        toptitle.setText("我的动态");
        righ_cerame.setBackground(getDrawable(R.mipmap.dating_circle_crame));
        back.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbtnlay:
                finish();
                break;

        }
    }
}
