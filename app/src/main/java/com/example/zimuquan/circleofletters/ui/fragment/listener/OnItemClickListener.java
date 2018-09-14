package com.example.zimuquan.circleofletters.ui.fragment.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by EDZ on 2018/9/11.
 */

public interface OnItemClickListener {
    void onItemClick(int position, View view, RecyclerView.ViewHolder vh);
}