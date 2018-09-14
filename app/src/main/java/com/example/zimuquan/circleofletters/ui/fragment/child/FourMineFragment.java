package com.example.zimuquan.circleofletters.ui.fragment.child;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.zimuquan.circleofletters.MemberCenterVipActivity;
import com.example.zimuquan.circleofletters.MineFeedbackActivity;
import com.example.zimuquan.circleofletters.MineMyDynamicActivity;
import com.example.zimuquan.circleofletters.MinePersonalityLabelActivity;
import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.ui.fragment.MineFragment;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class FourMineFragment extends SupportFragment implements View.OnClickListener{
    private RelativeLayout member_center;
    private RelativeLayout my_dynamic;
    private RelativeLayout my_label;
    private RelativeLayout feedback;
    public static FourMineFragment newInstance() {

        Bundle args = new Bundle();

        FourMineFragment fragment = new FourMineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fourmine_fragment_layout, container, false);
     //   EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }


    private void initView(View view) {
        member_center=view.findViewById(R.id.personal_member_center);
        my_dynamic=view.findViewById(R.id.personal_my_dynamic);
        my_label=view.findViewById(R.id.personal_my_label);
        feedback=view.findViewById(R.id.personal_feedback);
        member_center.setOnClickListener(this);
        my_dynamic.setOnClickListener(this);
        my_label.setOnClickListener(this);
        feedback.setOnClickListener(this);
    }

    @Override
    public boolean onBackPressedSupport() {
        // 这里实际项目中推荐使用 EventBus接耦
        ((MineFragment)getParentFragment()).onBackToFirstFragment();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_member_center:
                startActivity(new Intent(getActivity(),MemberCenterVipActivity.class));
                break;
            case R.id.personal_my_dynamic:
                startActivity(new Intent(getActivity(),MineMyDynamicActivity.class));
                break;
            case R.id.personal_my_label:
                startActivity(new Intent(getActivity(),MinePersonalityLabelActivity.class));
                break;
            case R.id.personal_feedback:
                startActivity(new Intent(getActivity(),MineFeedbackActivity.class));
                break;

        }
    }
}
