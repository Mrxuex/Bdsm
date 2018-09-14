package com.example.zimuquan.circleofletters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.carrier.CarrierService;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.system.DataCleanManager;

import butterknife.BindView;
import butterknife.OnClick;
import ch.ielse.view.SwitchView;

/**
 * Created by EDZ on 2018/9/13.
 */

public class MineSetActivity extends BaseActivity {

    private Context context;
    /*switchbutton按钮切换*/
    @BindView(R.id.switch_button)
    SwitchView switch_btn;
   /* title_头部*/
    @BindView(R.id.backbtnlay)
    ImageView backbtnlay;
    @BindView(R.id.toptitleText)
    TextView titleText;

     /*子项*/
    @BindView(R.id.mine_blacklist)
    LinearLayout blacklist;
    @BindView(R.id.mine_about_us)
    LinearLayout about_us;
    @BindView(R.id.mine_clean_cache)
    LinearLayout clean_cache;

    @BindView(R.id.text_clear_num)
    TextView clear_num;

    /*退出*/
    @BindView(R.id.mine_exit_login)
    LinearLayout exit_login;

    DataCleanManager dataCleanManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_setting_layout;
    }

    @Override
    public void initView() {
        titleText.setText("设置");


        try {
            clear_num.setText(dataCleanManager.getTotalCacheSize(context));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.switch_button,R.id.backbtnlay,R.id.mine_blacklist,R.id.mine_about_us,R.id.mine_clean_cache,R.id.mine_exit_login})
    public void click(View view) {
        switch (view.getId()){
            case R.id.switch_button:
                break;
            case R.id.backbtnlay:
                finish();
                break;
            case R.id.mine_blacklist:
                startActivity(new Intent(MineSetActivity.this,BlackBookActivity.class));
                break;
            case R.id.mine_about_us:
                startActivity(new Intent(MineSetActivity.this,OboutUsActivity.class));
                break;
            case R.id.mine_clean_cache:
                dataCleanManager.clearAllCache(context);
                clear_num.setText("0MB");
                break;
            case R.id.mine_exit_login:
                //账号退出登录--登录信息清空
                break;

        }

    }
}
