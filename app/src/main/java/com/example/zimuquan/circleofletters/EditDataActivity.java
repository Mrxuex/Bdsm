package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.base.BaseActivity;
import com.example.zimuquan.circleofletters.ui.view.circleimageview.CircularImage;

import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;


/**
 * Created by EDZ on 2018/9/11.
 */

public class EditDataActivity extends BaseActivity {

    @BindView(R.id.toptitleText)
    TextView toptitleText;
    @BindView(R.id.backbtnlay)
    ImageView backbtn;

    @BindView(R.id.user_img)
    CircularImage usre_iamge;


    @BindView(R.id.my_cichen)
    EditText name;
    @BindView(R.id.my_birthday)
    TextView birthday;
    @BindView(R.id.my_sex)
    TextView sex;
    @BindView(R.id.my_city)
    TextView city;
    @BindView(R.id.registered_ok)
    Button registered;


    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
   // Bundle bundle = getIntent().getExtras();
    //String testBundleString = bundle.getString("Name");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // setTitle(true);
        //setState(true);

        super.onCreate(savedInstanceState);
        initView();

    }

    @Override
    public int intiLayout() {

        return R.layout.edit_data_layout;
    }

    @Override
    public void initView() {
        toptitleText.setText("编辑资料");
    }

    @Override
    public void initData() {

    }
    @OnClick({R.id.backbtnlay,R.id.user_img,R.id.my_birthday,R.id.my_sex,R.id.my_city,R.id.registered_ok})
    public void click(View view) {
        switch (view.getId()){
            case R.id.backbtnlay:
                finish();
                break;
            case R.id.user_img:
                break;
            case R.id.my_birthday:
                onYearMonthDayPicker();
                break;
            case R.id.my_sex:
                break;
            case R.id.my_city:
                break;
            case R.id.registered_ok:
                //Toast.makeText(this,"2132132",Toast.LENGTH_SHORT).show();
                onYearMonthDayPicker();
                break;

        }

    }
    private void onYearMonthDayPicker() {
        final DatePicker picker = new DatePicker(this);
        picker.setCanceledOnTouchOutside(true);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(this, 20));
        picker.setRangeEnd(2050, 10, 14);//控件最大所能显示的时间，即结束时间
        picker.setRangeStart(1997, 1, 1);//控件最小所能显示的时间
        picker.setSelectedItem(mYear, mMonth, mDay);//默认选择时间
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                birthday.setText(year + "-" + month + "-" + day);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }

}
