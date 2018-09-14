package com.example.zimuquan.circleofletters.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.ui.fragment.entiy.Article;
import com.example.zimuquan.circleofletters.ui.fragment.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EDZ on 2018/9/12.
 */


public class HomeNewPeopleAdapter  extends RecyclerView.Adapter<HomeNewPeopleAdapter.MyViewHolder> {
    private List<Article> mItems = new ArrayList<>();
    private LayoutInflater mInflater;

    private OnItemClickListener mClickListener;

    public HomeNewPeopleAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void setDatas(List<Article> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_home_newpeople, parent, false);
        final MyViewHolder holder =new  MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, v, holder);
                }
            }
        });
        return holder;
    }

    /*@Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }*/

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article item = mItems.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public Article getItem(int position) {
        return mItems.get(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}

