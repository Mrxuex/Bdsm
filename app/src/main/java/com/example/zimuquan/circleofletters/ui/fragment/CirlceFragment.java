package com.example.zimuquan.circleofletters.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.base.BaseMainFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.FirstHomeFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.SecondCircleFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class CirlceFragment extends BaseMainFragment {



        public static CirlceFragment newInstance() {

            Bundle args = new Bundle();

            CirlceFragment fragment = new CirlceFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.cirlce_fragment_second, container, false);
            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            if (findChildFragment(SecondCircleFragment.class) == null) {
                loadRootFragment(R.id.fl_second_container, SecondCircleFragment.newInstance());
            }
        }

        @Override
        public void onLazyInitView(@Nullable Bundle savedInstanceState) {
            super.onLazyInitView(savedInstanceState);
            // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create
        }
    }
