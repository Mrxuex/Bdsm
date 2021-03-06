package com.example.zimuquan.circleofletters.ui.fragment.child.childpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zimuquan.circleofletters.MainActivity;
import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.WalkActivity;
import com.example.zimuquan.circleofletters.event.TabSelectedEvent;
import com.example.zimuquan.circleofletters.modle.WalkArtice;
import com.example.zimuquan.circleofletters.ui.adapter.HomeAdapter;
import com.example.zimuquan.circleofletters.ui.adapter.WalkHomeAdapter;
import com.example.zimuquan.circleofletters.ui.fragment.child.FirstHomeFragment;
import com.example.zimuquan.circleofletters.ui.fragment.entiy.Article;
import com.example.zimuquan.circleofletters.ui.fragment.listener.OnItemClickListener;
import com.example.zimuquan.circleofletters.utils.URLUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by EDZ on 18/6/3.
 */
public class FirstPagerFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener {
    private ListView mRecy;
    private SwipeRefreshLayout mRefreshLayout;
    //  private HomeAdapter mAdapter;
    private boolean mAtTop = true;
    private int mScrollTotal;
    WalkHomeAdapter myAdapter;

  //  List<WalkArtice.DataBean> lists;
    private Context context;
   // private HomeAdapter myAdapter;
    private URL url = null;

    /*考虑后期线程工程，可以迁移代码*/
    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            List<WalkArtice.DataBean> lists = (List<WalkArtice.DataBean>) msg.obj;
            myAdapter = new WalkHomeAdapter(_mActivity, lists);
            mRecy.setAdapter(myAdapter);
        }
    };

    public static FirstPagerFragment newInstance() {

        Bundle args = new Bundle();

        FirstPagerFragment fragment = new FirstPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_fragment_homepager_first, container, false);
        EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecy = (ListView) view.findViewById(R.id.recy);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);


        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);



        new Thread() {
            public void run() {
                try {

                        url = new URL(URLUtils.getTouristsHomepage() + "1");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);

                    int code = connection.getResponseCode();
                    if (code == 200) {
                        //5
                        InputStream inputStream = connection.getInputStream();

                        String content = streamToString(inputStream);
                        Gson gson = new Gson();
                        WalkArtice news = gson.fromJson(content, WalkArtice.class);

                        List<WalkArtice.DataBean> newslist = news.getData();

                        Message msg = Message.obtain();
                        msg.obj = newslist;
                        myHandler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //  mAdapter = new HomeAdapter(_mActivity);
        // lists=new List<WalkArtice.DataBean> datas[];
        //myAdapter = new WalkHomeAdapter(_mActivity, lists);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
       // mRecy.setLayoutManager(manager);
        //   mRecy.setAdapter(mAdapter);

    /*    mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                // 这里的DetailFragment在flow包里
                // 这里是父Fragment启动,要注意 栈层级
              //  ((SupportFragment) getParentFragment()).start(DetailFragment.newInstance(mAdapter.getItem(position).getTitle()));
            }
        });*/

     /*   // Init Datas
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = (int) (Math.random() * 3);
            Article article = new Article(mTitles[index], mContents[index]);
            articleList.add(article);
        }
        mAdapter.setDatas(articleList);*/




/*      刷新*/
      /*  mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        });*/
    }

    /*类型转换显示*/
    public String streamToString(InputStream is) {
        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String con;
        try {
            while ((con = reader.readLine()) != null) {
                builder.append(con);
            }
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return builder.toString();
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

    /**
     * 选择tab事件
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainActivity.SECOND) return;

        if (mAtTop) {
            mRefreshLayout.setRefreshing(true);
            onRefresh();
        } else {
            scrollToTop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }

}
