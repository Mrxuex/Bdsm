package com.example.zimuquan.circleofletters.ui.fragment.child;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zimuquan.circleofletters.MainActivity;
import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.event.TabSelectedEvent;
import com.example.zimuquan.circleofletters.ui.adapter.HomePagerFragmentAdapter;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class FirstHomeFragment extends SupportFragment {


    private TabLayout mTab;
    private ViewPager mViewPager;


    public static FirstHomeFragment newInstance() {

        Bundle args = new Bundle();

        FirstHomeFragment fragment = new FirstHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_fragment_first_home, container, false);
//        EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }



    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new HomePagerFragmentAdapter(getChildFragmentManager(),
                getString(R.string.homepager_recommend), getString(R.string.homepager_circle), getString(R.string.homepager_newpeople)
               ));
        mTab.setupWithViewPager(mViewPager);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }
}
