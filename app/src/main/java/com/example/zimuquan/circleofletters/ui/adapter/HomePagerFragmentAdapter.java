package com.example.zimuquan.circleofletters.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Adapter;

import com.example.zimuquan.circleofletters.ui.fragment.child.SecondCircleFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.childpager.FirstPagerFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.childpager.OtherPagerFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.childpager.SecondPagerFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.childpager.ThredPagerFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class HomePagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public HomePagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }
/*三个tabbar适配*/
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FirstPagerFragment.newInstance();
        } else if (position==1){
            /*这里需要适配*/
            return SecondPagerFragment.newInstance();
        }else{
            return ThredPagerFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
