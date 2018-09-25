package com.example.zimuquan.circleofletters;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.base.BdsM;
import com.example.zimuquan.circleofletters.im.MainActivity1;
import com.example.zimuquan.circleofletters.modle.commom.Const;
import com.example.zimuquan.circleofletters.utils.ActivityUtil;
import com.example.zimuquan.circleofletters.utils.SPUtil;
import com.example.zimuquan.circleofletters.utils.StringUtil;
import com.example.zimuquan.circleofletters.utils.StringUtils;
import com.example.zimuquan.circleofletters.utils.URLUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 引导过渡
 * Created by EDZ on 2018/9/10.
 */
public class LandingActivity extends BaseActivity {


    @BindView(R.id.land_view)
    ImageView land_view;
    @BindView(R.id.fl_guide_countdown)
    FrameLayout fl_guide_countdown;
    @BindView(R.id.tv_guide_countdown)
    TextView countDownTv;
    private int count = 3;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);//设置是否显示标题栏
        setState(false);//设置是否显示状态栏
        super.onCreate(savedInstanceState);
        //toastLong("长时间弹出");
    }

    //设置子类的布局/**/
    @Override
    public int intiLayout() {

        return R.layout.activity_splash;
    }

    //初始化控件
    @Override
    public void initView() {

        fl_guide_countdown = findViewById(R.id.fl_guide_countdown);
        fl_guide_countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLoginActivity();
            }
        });




    }


    //初始化数据
    @Override
    public void initData() {


        mHandler = new Handler();
        mHandler.post(countDownRunnable);



/*
        mHandler = new Handler();
        if (StringUtil.isEmpty(SPUtil.Instance().read(Const.USER))) {
            boolean isChinese = BaseUtils.isZh(this);
            URLUtils.setServer(isChinese);
        } else {
            if (StringUtils.checkEmail(MeSmart.USER.getUsername())) {
                URLUtils.setServer(false);
            } else if (StringUtils.checkPhone(MeSmart.USER.getUsername())) {
                URLUtils.setServer(true);
            }
        }
        mHandler.post(countDownRunnable);
        DisplayImageOptions options = new DisplayImageOptions.Builder().showImageOnFail(R.drawable.landing)
                .showStubImage(R.drawable.landing).build();
        ImageLoader.getInstance().displayImage(URLUtils.getGuideImgUrl(), land_view, options);
        if(!MinaManager.getInstance().isConnect()) {
            startMinaService();
        }*/

    }



    public Runnable countDownRunnable = new Runnable() {
        @Override
        public void run() {
            countDownTv.setVisibility(View.VISIBLE);
            if (countDownTv != null) {
                countDownTv.setText(String.format(getString(R.string.skip), count));
            }
            if (count == 0) {
                startLoginActivity();
            } else {
                mHandler.postDelayed(this, 1000);
            }
            count--;
        }
    };

    @Override
    public void finish() {
        mHandler.removeCallbacks(countDownRunnable);
        overridePendingTransition(R.anim.fade_in_center, R.anim.fade_out_center);
        oldFinish();
    }

    public void oldFinish() {
        super.finish();
    }
    /**
     * 延迟两秒进入登录界面
     */
   /* private void startLoginActivity() {
       // 在此做是否第一次登陆判断else if
        startActivity(new Intent(LandingActivity.this, SpashActivity.class));
        this.finish();
    }*/
    /**
     * 延迟两秒进入登录界面
     */
    private void startLoginActivity() {
       // startActivity(new Intent(LandingActivity.this, MainActivity1.class));
        if (!StringUtil.isEmpty(SPUtil.Instance().read(Const.USER))) {
            BdsM.isResume = true;
            ActivityUtil.intentActivity(LandingActivity.this, MainActivity.class);
        } else if (SPUtil.Instance().readBoolean(Const.IS_NO_FIRST)) {
            ActivityUtil.intentActivity(LandingActivity.this, LoginActivity.class);
        } else {
            SPUtil.Instance().saveBoolean(Const.IS_NO_FIRST, true);
            ActivityUtil.intentActivity(LandingActivity.this, LoginActivity.class);
        }
        this.finish();




    }

    @OnClick(R.id.fl_guide_countdown)
    public void click(View view) {
        startLoginActivity();
    }



}