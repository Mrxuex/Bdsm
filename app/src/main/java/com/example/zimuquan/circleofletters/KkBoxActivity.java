package com.example.zimuquan.circleofletters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by EDZ on 2018/9/11.
 */

public class KkBoxActivity extends BaseActivity {

    @BindView(R.id.toptitleText)
    TextView toptitleText;
    @BindView(R.id.backbtnlay)
    ImageView backbtn;
    @BindView(R.id.image_s)
    ImageView images;
    @BindView(R.id.image_m)
    ImageView imagem;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //setTitle(true);
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int intiLayout() {
        return R.layout.kk_box_layout;
    }

    @Override
    public void initView() {
        toptitleText.setText("选择角色");

    }

    @Override
    public void initData() {

    }
    @OnClick({R.id.backbtnlay,R.id.image_s,R.id.image_m})
    public void click(View view) {
        switch(view.getId()){
            case R.id.backbtnlay:
                //弹出确定退出对话框
                new AlertDialog.Builder(this)
                        .setTitle("温馨提示")
                        .setMessage("还差一步即可来聊，确定要放弃吗？")
                        .setPositiveButton("我意已决", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                Intent exit = new Intent(Intent.ACTION_MAIN);
                                exit.addCategory(Intent.CATEGORY_HOME);
                                exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(exit);
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("再等一等", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.cancel();
                            }
                        })
                        .show();
                break;
            case R.id.image_s:
               // startActivity(new Intent(KkBoxActivity.this,EditDataActivity.class));

                Intent intent = new Intent();

                intent.setClass(KkBoxActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("Name", "S");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.image_m:
               // startActivity(new Intent(KkBoxActivity.this,EditDataActivity.class));


                Intent intent1 = new Intent();

                intent1.setClass(KkBoxActivity.this, EditDataActivity.class);

                Bundle bundle1 = new Bundle();
                bundle1.putString("Name", "M");
                intent1.putExtras(bundle1);
                startActivity(intent1);
                break;

        }


    }

    public void showToast(View view){

        LayoutInflater inflater = getLayoutInflater();

        //通过inflater对象加载自定义文件
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        // Set the title and description TextView from our custom layout
        //设置TextView标题与描述
        TextView title = (TextView) layout.findViewById(R.id.title);
        title.setText("温馨提示");

        TextView description = (TextView) layout.findViewById(R.id.description);
        description.setText("还差一步即可来聊，确定要放弃吗？");

        Button btnexit=layout.findViewById(R.id.btn_exit);
        Button btnless=layout.findViewById(R.id.btn_less);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
        btnless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Create and show the Toast object
        //创建Toast对象并展示toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
