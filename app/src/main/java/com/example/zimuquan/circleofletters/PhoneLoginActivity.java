package com.example.zimuquan.circleofletters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.http.okhttp.OkHttpUtils;
import com.example.zimuquan.circleofletters.modle.commom.Const;
import com.example.zimuquan.circleofletters.ui.view.OnclickButton;
import com.example.zimuquan.circleofletters.utils.SPUtil;
import com.example.zimuquan.circleofletters.utils.StreamTools;
import com.example.zimuquan.circleofletters.utils.TelNumMatch;
import com.example.zimuquan.circleofletters.utils.URLUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by EDZ on 2018/9/10.
 */

public class PhoneLoginActivity extends BaseActivity {

    @BindView(R.id.login_btn)
    OnclickButton onclickButton;
    @BindView(R.id.et_account)
    EditText phone_edit;
    @BindView(R.id.et_pwd)
    EditText phone_code;
    @BindView(R.id.card_showhas)
    TextView shaohascode;
    @BindView(R.id.pwd_showno)
    ImageView showno;
    @BindView(R.id.text_agreed_ok)
    TextView agredok;
    @BindView(R.id.login_weixin_textbtn)
    TextView loginwecaht;
    OkHttpUtils OkhttpUtil;
    private int time = 60;
    // private CountDownTimer countDownTimer;
    private Timer timer = new Timer();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public SPUtil Util;//数据存储的工具类

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitle(false);//设置是否显示标题栏
        setState(true);//设置是否显示状态栏

        super.onCreate(savedInstanceState);

    }

    @Override
    public int intiLayout() {
        return R.layout.phone_login_layout;
    }

    @Override
    public void initView() {
        Util = new SPUtil(this);
        final String username = SPUtil.Instance().read(Const.LAST_USE_NAME);

    }

    //方法3，使用TimerTask

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {      // UI thread
                @Override
                public void run() {
                    time--;
                    shaohascode.setText("已发送(" + String.valueOf(time) + ")");
                    shaohascode.setEnabled(false);
                    if (time <= 0) {
                        shaohascode.setEnabled(true);
                        shaohascode.setText("重新获取");
                    }
                }
            });
        }
    };

    @OnClick({R.id.login_btn, R.id.card_showhas, R.id.pwd_showno, R.id.text_agreed_ok, R.id.login_weixin_textbtn})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                // 获取用户名
                final String userName = phone_edit.getText().toString();
                // 获取用户密码
                final String userPass = phone_code.getText().toString();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPass)) {
                    Toast.makeText(this, "手机号或验证码有误", Toast.LENGTH_LONG).show();
                } else {
                    // 开启子线程
                    new Thread() {
                        public void run() {
                            loginByPost(userName, userPass); // 调用loginByPost方法
                        };
                    }.start();
                }
               // loginByPost(userName, userPass);
                break;

            //  startActivity(new Intent(PhoneLoginActivity.this, MainActivity.class));
            case R.id.card_showhas:
                //1.验证手机号
                String username_phone = phone_edit.getText().toString();
                if (!TelNumMatch.isValidPhoneNumber(username_phone)) {
                    Toast.makeText(PhoneLoginActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        timer.schedule(task, time, 1000);
                    } catch (Exception e) {
                    }
                }
                break;


            case R.id.pwd_showno:
                phone_edit.setText("");
                break;
            case R.id.text_agreed_ok:
                startActivity(new Intent(PhoneLoginActivity.this, UserAgreeUsBookActivity.class));
                break;
            case R.id.login_weixin_textbtn:
                //  Toast.makeText(PhoneLoginActivity.this, "微信登录待接如", Toast.LENGTH_SHORT).show();
                // login();
                /*微信登录*/
                break;
        }
        // startLoginActivity();
    }

    @Override
    public void initData() {

    }

    /**
     * POST请求操作
     *
     * @param userName
     * @param userPass
     */
    public void loginByPost(String userName, String userPass) {

        try {

            // 请求的地址
            String spec = URLUtils.TouristsUserLogin;
            // 根据地址创建URL对象
            URL url = new URL(spec);
            // 根据URL对象打开链接
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();
            // 设置请求的方式
            urlConnection.setRequestMethod("POST");
            // 设置请求的超时时间
            urlConnection.setReadTimeout(5000);
            urlConnection.setConnectTimeout(5000);
            // 传递的数据
            String data = "username=" + URLEncoder.encode(userName, "UTF-8")
                    + "&userpass=" + URLEncoder.encode(userPass, "UTF-8");
            // 设置请求的头
            urlConnection.setRequestProperty("Connection", "keep-alive");
            // 设置请求的头
            urlConnection.setRequestProperty("Content-Type",
                    "application/json");
            urlConnection.setDoOutput(true); // 发送POST请求必须设置允许输出
            urlConnection.setDoInput(true); // 发送POST请求必须设置允许输入
            //setDoInput的默认值就是true
            //获取输出流
            OutputStream os = urlConnection.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            if (urlConnection.getResponseCode() == 200) {
                // 获取响应的输入流对象
                InputStream is = urlConnection.getInputStream();
                // 创建字节输出流对象
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // 定义读取的长度
                int len = 0;
                // 定义缓冲区
                byte buffer[] = new byte[1024];
                // 按照缓冲区的大小，循环读取
                while ((len = is.read(buffer)) != -1) {
                    // 根据读取的长度写入到os对象中
                    baos.write(buffer, 0, len);
                }
                // 释放资源
                is.close();
                baos.close();
                // 返回字符串
                final String result = new String(baos.toByteArray());

                // 通过runOnUiThread方法进行修改主线程的控件内容
                PhoneLoginActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(PhoneLoginActivity.this,result,Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                System.out.println("链接失败.........");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
