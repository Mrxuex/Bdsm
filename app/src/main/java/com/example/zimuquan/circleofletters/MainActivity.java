package com.example.zimuquan.circleofletters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import com.example.zimuquan.circleofletters.base.BaseMainFragment;
import com.example.zimuquan.circleofletters.event.TabSelectedEvent;
import com.example.zimuquan.circleofletters.ui.bottom.BottomBar;
import com.example.zimuquan.circleofletters.ui.bottom.BottomBarTab;
import com.example.zimuquan.circleofletters.ui.fragment.CirlceFragment;
import com.example.zimuquan.circleofletters.ui.fragment.HomePageFragment;
import com.example.zimuquan.circleofletters.ui.fragment.MineFragment;
import com.example.zimuquan.circleofletters.ui.fragment.SessionFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.FirstHomeFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.FourMineFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.SecondCircleFragment;
import com.example.zimuquan.circleofletters.ui.fragment.child.ThredSessionFragment;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* 通过解耦同意解决OOM问题*/
        SupportFragment firstFragment = findFragment(HomePageFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomePageFragment.newInstance();
            mFragments[SECOND] = CirlceFragment.newInstance();
            mFragments[THIRD] = SessionFragment.newInstance();
            mFragments[FOURTH] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(CirlceFragment.class);
            mFragments[THIRD] = findFragment(SessionFragment.class);
            mFragments[FOURTH] = findFragment(MineFragment.class);
        }

        initView();
    }

    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.dating_tabbar_home_nor,"首页"))
                .addItem(new BottomBarTab(this, R.mipmap.dating_tabbar_cirlce_nor,"动态"))
                .addItem(new BottomBarTab(this, R.mipmap.dating_tabbar_session_nor,"消息"))
                .addItem(new BottomBarTab(this, R.mipmap.dating_tabbar_mine_nor,"我的"));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {

                showHideFragment(mFragments[position], mFragments[prePosition]);
                  /*  if(position==0){
                        mBottomBar.set
                    }else if (position==1){

                    }else if (position==2){

                    }else if(position==3){

                    }else{

                    }*/

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();

                // 如果不在该类别Fragment的主页,则回到主页;
                if (count > 1) {
                    if (currentFragment instanceof HomePageFragment) {
                        currentFragment.popToChild(FirstHomeFragment.class, false);

                    } else if (currentFragment instanceof CirlceFragment) {
                        currentFragment.popToChild(SecondCircleFragment.class, false);
                    } else if (currentFragment instanceof SessionFragment) {
                        currentFragment.popToChild(ThredSessionFragment.class, false);
                    } else if (currentFragment instanceof MineFragment) {
                        currentFragment.popToChild(FourMineFragment.class, false);
                    }
                    return;
                }


                // 这里推荐使用EventBus来实现 -> 解耦
                if (count == 1) {
                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                    EventBusActivityScope.getDefault(MainActivity.this).post(new TabSelectedEvent(position));
                }
            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void onBackToFirstFragment() {
        mBottomBar.setCurrentItem(0);
    }

    /**
     * 这里暂没实现,忽略
     */
//    @Subscribe
//    public void onHiddenBottombarEvent(boolean hidden) {
//        if (hidden) {
//            mBottomBar.hide();
//        } else {
//            mBottomBar.show();
//        }
//    }
}

