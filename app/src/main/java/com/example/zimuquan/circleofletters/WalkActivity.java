package com.example.zimuquan.circleofletters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.modle.WalkArtice;
import com.example.zimuquan.circleofletters.ui.adapter.WalkHomeAdapter;
import com.example.zimuquan.circleofletters.ui.fragment.listener.OnItemClickListener;
import com.example.zimuquan.circleofletters.ui.view.MyEditText;
import com.example.zimuquan.circleofletters.ui.view.OnclickButton;
import com.example.zimuquan.circleofletters.utils.URLUtils;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.example.zimuquan.circleofletters.ui.adapter.WalkHomeAdapter.Callback;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by EDZ on 2018/9/13.
 */

public class WalkActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toptitleText)
    TextView toptitleText;
    @BindView(R.id.backbtnlay)
    ImageView backbtn;
    @BindView(R.id.recy)
    ListView recylist;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    WalkHomeAdapter myAdapter;
    private URL url = null;
    private PopupWindow popupWindow;




    /*考虑后期线程工程，可以迁移代码*/
    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            List<WalkArtice.DataBean> lists = (List<WalkArtice.DataBean>) msg.obj;
            myAdapter = new WalkHomeAdapter(WalkActivity.this, lists);
            recylist.setAdapter(myAdapter);
            myAdapter.setOnItemloveClickListener(new WalkHomeAdapter.onItemLoveListener() {
                @Override
                public void onloveClick(int postion) {


                    View itemView = View.inflate(WalkActivity.this, R.layout.mypop_item_login_layout, null);


                    ImageView imageView = itemView.findViewById(R.id.image_exit1);
                    MyEditText phonenum = itemView.findViewById(R.id.et_account);
                    MyEditText card = itemView.findViewById(R.id.et_pwd);
                    TextView carbtn = itemView.findViewById(R.id.card_showhas);
                    OnclickButton onclickButton = itemView.findViewById(R.id.login_btn);
                    TextView textView = itemView.findViewById(R.id.text_agreed_ok);
                    TextView textView1 = itemView.findViewById(R.id.login_weixin_textbtn);


                    /* 点击隐藏叉叉*/
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (popupWindow != null) {
                                popupWindow.dismiss();
                            }
                        }
                    });
                    onclickButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String phone = phonenum.getText().toString();
                            String phonecard = card.getText().toString();

                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(WalkActivity.this, UserAgreeUsBookActivity.class));
                        }
                    });
                    textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(WalkActivity.this, "微信申请种", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //创建popupWindow,第一个参数是自定义的view,第二个参数分别是popupWindow的宽和高(第四个参数是聚集(true/false),下面手动设置了)
                    popupWindow = new PopupWindow(itemView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    //触摸点击事件
                    popupWindow.setTouchable(true);
                    //聚集
                    popupWindow.setFocusable(true);
                    //设置允许在外点击消失
                    popupWindow.setOutsideTouchable(true);
                    //点击返回键popupwindown消失
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    //背景变暗
                    WindowManager.LayoutParams params = WalkActivity.this.getWindow().getAttributes();
                    params.alpha = 0.1f;
                    WalkActivity.this.getWindow().setAttributes(params);
                    popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            return false;
                        }
                    });
                    //监听如果popupWindown消失之后背景变亮
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            WindowManager.LayoutParams params = WalkActivity.this.getWindow()
                                    .getAttributes();
                            params.alpha = 1f;
                            WalkActivity.this.getWindow().setAttributes(params);
                        }

                    });
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ffffff")));
                    popupWindow.showAtLocation(itemView.getRootView().getRootView(), Gravity.CENTER, 0, 0);

                }


            });
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int intiLayout() {
        return R.layout.main_walk_layout;
    }

    @Override
    public void initView() {
        toptitleText.setText("逛一逛");
        swipeRefreshLayout.setColorSchemeResources(R.color.textColorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this);

        //ListView item的点击事件
        recylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(WalkActivity.this, PersonalHomepageActivity.class));

            }
        });

    }

    @Override
    public void initData() {

        //获取数据
        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("Message");
        //获取数据
        final String name = bundle.getString("name");

        new Thread() {
            public void run() {
                try {
                    if (name.equals("女")) {
                        url = new URL(URLUtils.getTouristsHomepage() + "1");
                    } else {
                        url = new URL(URLUtils.getTouristsHomepage() + "2");
                    }
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
                        WalkArtice news = gson.fromJson(content, WalkArtice.class);

                        List<WalkArtice.DataBean> newslist = news.getData();

                        Message msg = Message.obtain();
                        msg.obj = newslist;
                        myHandler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


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

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                myAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);

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
