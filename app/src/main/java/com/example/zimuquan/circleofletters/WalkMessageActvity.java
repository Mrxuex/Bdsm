package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/18.
 */

public class WalkMessageActvity extends BaseActivity {

    @BindView(R.id.toptitleText)
    TextView toptitleText;
    @BindView(R.id.backbtnlay)
    ImageView backbtn;


    @BindView(R.id.image_man)
    ImageView images;
    @BindView(R.id.image_women)
    ImageView imagem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.wlak_mess_layout;
    }

    @Override
    public void initView() {
        toptitleText.setText("逛一逛");
    }
    @Override
    public void initData() {

    }
    @OnClick({R.id.backbtnlay, R.id.image_man, R.id.image_women})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.backbtnlay:
                finish();
                break;
            case R.id.image_man:
                Bundle bundle = new Bundle();
                Intent intent = new Intent();

                intent.setClass(WalkMessageActvity.this, WalkActivity.class);


                //设置数据
                String name="女";
                //把数据保存到Bundle里
                bundle.putString("name", name);
                //把bundle放入intent里
                intent.putExtra("Message",bundle);
                startActivity(intent);
                break;
            case R.id.image_women:
                Intent intent1 = new Intent();
                Bundle bundle1 = new Bundle();
                intent1.setClass(WalkMessageActvity.this, WalkActivity.class);
                //设置数据
                String name1="男";
                //把数据保存到Bundle里
                bundle1.putString("name", name1);
                //把bundle放入intent里
                intent1.putExtra("Message",bundle1);
                startActivity(intent1);
                break;
        }

    }
}
