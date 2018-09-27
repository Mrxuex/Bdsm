package com.example.zimuquan.circleofletters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.modle.user.UserAllInfo;
import com.example.zimuquan.circleofletters.utils.URLUtils;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/12.
 */

public class PersonalHomepageActivity extends BaseActivity {

    @BindView(R.id.toptitleText)
    TextView toptitleText;
    @BindView(R.id.backbtnlay)
    ImageView backbtn;
    @BindView(R.id.black_imgae)
    ImageView imageView1;

    @BindView(R.id.user_name)
    TextView usernaem;
    @BindView(R.id.city_text)
    TextView textcity;
    @BindView(R.id.m_text)
    TextView mtext;
    @BindView(R.id.nichen_nickname)
    TextView nichen_nick;
    @BindView(R.id.age_text)
    TextView age_text;

    @BindView(R.id.age_text1)
    TextView age_text1;
    @BindView(R.id.city_text1)
            TextView textViewcity;

    @BindView(R.id.text_m)
            TextView text_m1;
    URL url;


    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.arg1) {

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public int intiLayout() {
        return R.layout.persion_homepage_layout;
    }

    @Override
    public void initView() {
       // toptitleText.setText("游客名字");
    }

    @Override
    public void initData() {
        //取得启动该Activity的Intent对象
        //  Intent intent =getIntent();
        /*取出Intent中附加的数据*/
        //  String user_id = intent.getStringExtra("usreid");
        //  int userid=Integer.parseInt(user_id);
        new Thread() {
            public void run() {
                try {
                    url = new URL(URLUtils.TouristsUserID + "21");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);

                    int code = connection.getResponseCode();
                    if (code == 200) {
                        //5
                        InputStream inputStream = connection.getInputStream();

                        String content = streamToString(inputStream);
                        Gson gson = new Gson();
                        UserAllInfo news = gson.fromJson(content, UserAllInfo.class);

                        // UserAllInfo.DataBean id = new UserAllInfo.DataBean();
                        // imageView1.setImageDrawable(id.getAvatar());

                        URL picUrl = new URL(news.getData().getAvatar());
                        Bitmap pngBM = BitmapFactory.decodeStream(picUrl.openStream());
                        imageView1.setImageBitmap(pngBM);

                        toptitleText.setText(""+news.getData().getNick_name());
                        usernaem.setText(""+news.getData().getNick_name());
                        nichen_nick.setText(""+news.getData().getNick_name());

                        textcity.setText(""+news.getData().getLocation());
                        textViewcity.setText(""+news.getData().getLocation());

                        mtext.setText(""+news.getData().getProperty());
                        text_m1.setText(""+news.getData().getProperty());

                        age_text1.setText(""+news.getData().getAge());
                        age_text.setText(""+news.getData().getAge());


                        Message msg = Message.obtain();
                        myHandler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @OnClick(R.id.backbtnlay)
    public void click(View view) {
        switch (view.getId()) {
            case R.id.backbtnlay:
                finish();
                break;

        }
    }

    /*类型转换显示*/
    public String streamToString(InputStream is) {
        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String con;
        try {
            while ((con = reader.readLine()) != null) {
                builder.append(con);
            }
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return builder.toString();
    }
}
