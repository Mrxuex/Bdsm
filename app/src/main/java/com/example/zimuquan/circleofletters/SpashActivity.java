package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.utils.SocialUtil;
import net.arvin.socialhelper.SocialHelper;
import net.arvin.socialhelper.callback.SocialLoginCallback;
import net.arvin.socialhelper.callback.SocialShareCallback;
import net.arvin.socialhelper.entities.ThirdInfoEntity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/10.
 */

public class SpashActivity extends BaseActivity implements  SocialLoginCallback, SocialShareCallback {

    @BindView(R.id.fl_guide_countdown_phone)
    FrameLayout view_phone;
    @BindView(R.id.fl_guide_wechat)
    FrameLayout view_wechat;
    @BindView(R.id.fl_guide_guanguan)
    FrameLayout view_guangguan;
    @BindView(R.id.fl_guide_icah)
    FrameLayout view_icah;

    private SocialHelper socialHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);//设置是否显示标题栏
        setState(false);//设置是否显示状态栏
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int intiLayout() {
        return R.layout.shash_layout;
    }

    @Override
    public void initView() {
        socialHelper = SocialUtil.INSTANCE.socialHelper;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.fl_guide_countdown_phone, R.id.fl_guide_guanguan, R.id.fl_guide_wechat,R.id.fl_guide_icah})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.fl_guide_countdown_phone:
                startActivity(new Intent(SpashActivity.this, PhoneLoginActivity.class));
                break;
            case R.id.fl_guide_guanguan:
                startActivity(new Intent(SpashActivity.this, WalkMessageActvity.class));
                break;
            case R.id.fl_guide_wechat:
               // Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();

                socialHelper.loginWX(this, this);
                break;
            case R.id.fl_guide_icah:
                startActivity(new Intent(SpashActivity.this,UserAgreeUsBookActivity.class));
                break;
        }


        // startLoginActivity();
    }

    //用处：qq登录和分享回调，以及微博登录回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && socialHelper != null) {//qq分享如果选择留在qq，通过home键退出，再进入app则不会有回调
            socialHelper.onActivityResult(requestCode, resultCode, data);
        }
    }
    //用处：微博分享回调
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (socialHelper != null) {
            socialHelper.onNewIntent(intent);
        }
    }


    @Override
    public void loginSuccess(ThirdInfoEntity info) {
        Toast.makeText(this, toString(info)+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void shareSuccess(int type) {
        Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void socialError(String msg) {

    }

    private String toString(ThirdInfoEntity info) {
        return "登录信息 = {" +
                "unionId='" + info.getUnionId() + '\'' +
                ", openId='" + info.getOpenId() + '\'' +
                ", nickname='" + info.getNickname() + '\'' +
                ", sex='" + info.getSex() + '\'' +
                ", avatar='" + info.getAvatar() + '\'' +
                ", platform='" + info.getPlatform() + '\'' +
                '}';
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (socialHelper != null) {
            socialHelper.clear();
        }
    }
}
