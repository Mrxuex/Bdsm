package com.example.zimuquan.circleofletters.ui.fragment.child;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.ui.adapter.HomePagerFragmentAdapter;
import com.example.zimuquan.circleofletters.ui.adapter.SessionMessageFragmentAdapter;
import com.example.zimuquan.circleofletters.ui.fragment.entiy.Article;
import com.example.zimuquan.circleofletters.ui.fragment.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by EDZ on 2018/9/11.
 */
/*消息*/
public class ThredSessionFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener  {


    private RecyclerView mRecy;
    private SwipeRefreshLayout mRefreshLayout;
    private boolean mAtTop = true;
    private int mScrollTotal;
    private String[] mTitles;
    private String[] mContents;
private SessionMessageFragmentAdapter mAdapter;

    public static ThredSessionFragment newInstance() {

        Bundle args = new Bundle();

        ThredSessionFragment fragment = new ThredSessionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messagepage_fragment_message, container, false);
        //  EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }


    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);

        mTitles = getResources().getStringArray(R.array.array_title);
        mContents = getResources().getStringArray(R.array.array_content);

        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mAdapter = new SessionMessageFragmentAdapter(_mActivity);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                // 这里的DetailFragment在flow包里
                // 这里是父Fragment启动,要注意 栈层级
                //  ((SupportFragment) getParentFragment()).start(DetailFragment.newInstance(mAdapter.getItem(position).getTitle()));
            }
        });

        // Init Datas
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = (int) (Math.random() * 3);
            Article article = new Article(mTitles[index], mContents[index]);
            articleList.add(article);
        }
        mAdapter.setDatas(articleList);

        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollTotal += dy;
                if (mScrollTotal <= 0) {
                    mAtTop = true;
                } else {
                    mAtTop = false;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    private void scrollToTop() {
        mRecy.smoothScrollToPosition(0);
    }

}
