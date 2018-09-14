package com.example.zimuquan.circleofletters.ui.fragment.child.childfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.MineSetActivity;
import com.example.zimuquan.circleofletters.R;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by EDZ on 2018/9/11.
 */

public class AvatarFragment extends SupportFragment {
    /* title_头部*/

    private  TextView setingview;


    public static AvatarFragment newInstance() {

        Bundle args = new Bundle();

        AvatarFragment fragment = new AvatarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment_fourth_avatar, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
       setingview=view.findViewById(R.id.textView2);


        setingview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MineSetActivity.class));

            }
        });

    }
  /*  @OnClick(R.id.textView2)
    public void click(View view) {
        switch (view.getId()){
            case R.id.textView2:
                startActivity(new Intent(getActivity(), MineSetActivity.class));
                break;
        }
    }*/
}