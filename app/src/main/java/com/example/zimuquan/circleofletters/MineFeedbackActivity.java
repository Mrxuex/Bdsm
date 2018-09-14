package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

/**
 * Created by EDZ on 2018/9/14.
 */

public class MineFeedbackActivity extends BaseActivity {

    final int maxNum = 500;
    private TextView leftNum;
    private   EditText ed;

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
        leftNum=  (TextView) findViewById(R.id.left_num);
        ed= (EditText) findViewById(R.id.nike_num_max);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                leftNum.setText("300/"+ (maxNum-s.length()));
            }
        });
    }

    @Override
    public void initData() {

    }


}

