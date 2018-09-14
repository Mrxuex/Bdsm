package com.example.zimuquan.circleofletters.ui.view;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by Administrator on 2018/11/2.
 */
public class OnclickButton extends AppCompatButton implements View.OnClickListener {

    public OnclickButton(Context context) {
        super(context);
    }

    public OnclickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OnclickButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View v) {
     //   BaseUtils.doURLLog("v.getContext()-----------" + v.getContext().getPackageName(), "v.getId()------------" + v.getId());
    }
}
