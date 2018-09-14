package com.example.zimuquan.circleofletters.ui.view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by Administrator on 2018/9/2.
 */
public class MyEditText extends AppCompatEditText {

    public List<MyEditText> textViews;
    public Button btn;
    private boolean isEnable = true;

    public MyEditText(Context context) {
        super(context);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    public void setInitView(List<MyEditText> textViews, Button btn) {
        this.textViews = textViews;
        this.btn = btn;
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setEnable();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    //设置删除图片
    private void setEnable() {
        isEnable = true;
        for (EditText et : textViews) {
            if (et.getText().length() < 1) {
                btn.setEnabled(false);
                isEnable = false;
            }
        }
        if (isEnable) {
            btn.setEnabled(true);
        }
    }
}
