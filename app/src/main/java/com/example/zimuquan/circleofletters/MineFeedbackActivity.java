package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by EDZ on 2018/9/14.
 */

public class MineFeedbackActivity extends BaseActivity implements View.OnClickListener {

    final int maxNum = 300;
    private TextView leftNum;
    private EditText ed;
    @BindView(R.id.toptitleText)
    TextView toptitle;
    @BindView(R.id.backbtnlay)
    ImageView back;
    @BindView(R.id.rightlay)
    TextView textView_rig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.mine_feedbook_layout;
    }

    @Override
    public void initView() {
        toptitle.setText("投诉意见");
        textView_rig.setText("提交");
        back.setOnClickListener(this);
        leftNum = (TextView) findViewById(R.id.left_num);
        ed = (EditText) findViewById(R.id.nike_num_max);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                leftNum.setText( (maxNum - s.length())+"/300");
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbtnlay:
                finish();
                break;

        }
    }
}

