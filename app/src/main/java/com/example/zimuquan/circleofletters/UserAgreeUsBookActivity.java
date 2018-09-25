package com.example.zimuquan.circleofletters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/13.
 */

public class UserAgreeUsBookActivity extends BaseActivity {
     //title_头部
    @BindView(R.id.backbtnlay)
    ImageView backbtnlay;
    @BindView(R.id.toptitleText)
    TextView titleText;
   private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_set_usragreeusbook_layout;
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void initView() {
        titleText.setText("用户协议和隐私条款");
         webView = (WebView)findViewById(R.id.web_view_useragern);

        webView.loadUrl("file:///android_asset/bdsm_protocol.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //自适应屏幕

        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        webView.getSettings().setLoadWithOverviewMode(true);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        webView.destroy();
        webView=null;
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
