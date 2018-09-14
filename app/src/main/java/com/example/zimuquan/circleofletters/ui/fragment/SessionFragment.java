package com.example.zimuquan.circleofletters.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.base.BaseMainFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.ThredSessionFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class SessionFragment extends BaseMainFragment {

    public static SessionFragment newInstance() {

        Bundle args = new Bundle();

        SessionFragment fragment = new SessionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.session_fragment_third, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        if (findChildFragment(ThredSessionFragment.class) == null) {
            // ShopFragment是flow包里的
            loadRootFragment(R.id.fl_third_container, ThredSessionFragment.newInstance());
        }
    }
}
