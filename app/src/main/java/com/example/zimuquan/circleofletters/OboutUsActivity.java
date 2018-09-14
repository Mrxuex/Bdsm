package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/13.
 */

public class OboutUsActivity extends BaseActivity {

    /* title_头部*/
    @BindView(R.id.backbtnlay)
    ImageView backbtnlay;
    @BindView(R.id.toptitleText)
    TextView titleText;
    @BindView(R.id.privacy)
    TextView privacy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.miine_set_oboutus_layout;
    }

    @Override
    public void initView() {
        titleText.setText("关于我们");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.backbtnlay,R.id.privacy})
    public void click(View view) {
        switch (view.getId()) {

            case R.id.backbtnlay:
                finish();
                break;
            case R.id.privacy:
                startActivity(new Intent(OboutUsActivity.this,UserAgreeUsBookActivity.class));
                break;

        }
    }

}
