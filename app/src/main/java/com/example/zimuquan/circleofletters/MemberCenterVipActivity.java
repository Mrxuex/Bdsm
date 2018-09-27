package com.example.zimuquan.circleofletters;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import org.w3c.dom.Text;

/**
 * Created by EDZ on 2018/9/14.
 */

public class MemberCenterVipActivity extends BaseActivity implements View.OnClickListener {
    @Override
    public int intiLayout() {
        return R.layout.mine_membervip_layout;
    }

    @Override
    public void initView() {
        ImageView imageView = findViewById(R.id.backbtnlay);
        TextView textView = findViewById(R.id.toptitleText);
        LinearLayout bottmlinear = findViewById(R.id.bottom_immediately_opened);
        textView.setText("会员中心");
        imageView.setOnClickListener(this);
        bottmlinear.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbtnlay:
                finish();
                break;
            case R.id.bottom_immediately_opened:
                showPopwindow();
                break;

        }
    }

    private void showPopwindow() {
        View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        View popView = View.inflate(this, R.layout.camera_pop_menu_pay, null);
       /*  Button btnCamera = (Button) popView.findViewById(R.id.btn_camera_pop_camera);
        Button btnAlbum = (Button) popView.findViewById(R.id.btn_camera_pop_album);
        Button btnCancel = (Button) popView.findViewById(R.id.btn_camera_pop_cancel);

       OnClickListener listener = new OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_camera_pop_camera:
                        break;
                    case R.id.btn_camera_pop_album:
                        break;
                    case R.id.btn_camera_pop_cancel:
                        break;
                }
                popWindow.dismiss();
            }
        };
        btnCamera.setOnClickListener(listener);
        btnAlbum.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);*/
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        final PopupWindow popWindow = new PopupWindow(popView, width, height);
     //   popWindow.setAnimationStyle(R.style.AnimBottom);
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);// 设置允许在外点击消失
        ColorDrawable dw = new ColorDrawable(0x30000000);
        popWindow.setBackgroundDrawable(dw);
        popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }


}
