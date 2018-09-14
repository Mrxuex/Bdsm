package com.example.zimuquan.circleofletters.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.base.BaseMainFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.FourMineFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.childfour.AvatarFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class MineFragment extends BaseMainFragment {

    private View mView;

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.mine_fragment_fourth, container, false);
        return mView;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(AvatarFragment.class) == null) {
            loadFragment();
        }
    }

    private void loadFragment() {
        loadRootFragment(R.id.fl_fourth_container_upper, AvatarFragment.newInstance());
        loadRootFragment(R.id.fl_fourth_container_lower, FourMineFragment.newInstance());
    }

    public void onBackToFirstFragment() {
        _mBackToFirstListener.onBackToFirstFragment();
    }

}
