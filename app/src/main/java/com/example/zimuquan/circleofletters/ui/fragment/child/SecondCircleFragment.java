package com.example.zimuquan.circleofletters.ui.fragment.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.ui.adapter.HomePagerFragmentAdapter;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class SecondCircleFragment extends SupportFragment {


        private TabLayout mTab;
        private ViewPager mViewPager;


        public static SecondCircleFragment newInstance() {

                Bundle args = new Bundle();

                SecondCircleFragment fragment = new SecondCircleFragment();
                fragment.setArguments(args);
                return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.cirlcepage_fragment_first_circle, container, false);
                //  EventBusActivityScope.getDefault(_mActivity).register(this);
                initView(view);
                return view;
        }


        private void initView(View view) {
                mTab = (TabLayout) view.findViewById(R.id.tab);
                mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

                mTab.addTab(mTab.newTab());
                mTab.addTab(mTab.newTab());

                mViewPager.setAdapter(new HomePagerFragmentAdapter(getChildFragmentManager(),
                        getString(R.string.circlepager_all), getString(R.string.circlepager_cardiac)
                ));
                mTab.setupWithViewPager(mViewPager);
        }


        @Override
        public void onDestroyView() {
                super.onDestroyView();
                EventBusActivityScope.getDefault(_mActivity).unregister(this);
        }
}