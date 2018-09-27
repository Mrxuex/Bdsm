package com.example.zimuquan.circleofletters.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zimuquan.circleofletters.R;
import com.example.zimuquan.circleofletters.modle.WalkArtice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by EDZ on 2018/9/18.
 */

public class WalkHomeAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<WalkArtice.DataBean> mDatas;
    private Context mContext;

    public Callback mCallback;


    public WalkHomeAdapter(Context context, List<WalkArtice.DataBean> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        mContext=context;
    }

    //返回数据集的长度
    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_walk_layout, parent, false); //加载布局
            holder = new ViewHolder();

            holder.love_image = convertView.findViewById(R.id.image_love);
            holder.username = (TextView) convertView.findViewById(R.id.user_name);
            holder.citytext = (TextView) convertView.findViewById(R.id.city_text);
            holder.agetext = (TextView) convertView.findViewById(R.id.age_text);
            holder.mstext = (TextView) convertView.findViewById(R.id.m_text);
            holder.blackimgae = (ImageView) convertView.findViewById(R.id.black_imgae);
            convertView.setTag(holder);
        } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
            holder = (ViewHolder) convertView.getTag();
        }

        holder.love_image.setTag(position);

        WalkArtice.DataBean bean = mDatas.get(position);
        holder.username.setText(bean.getNick_name());
        holder.citytext.setText(bean.getLocation());
        holder.agetext.setText(bean.getAge() + "岁");
        holder.mstext.setText(bean.getProperty());
        holder.love_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monItemLoveListener1.onloveClick(position);
            }
        });

        //  Glide.with(this).load(url).into(holder.blackimgae);
        MypicTask mypictask = new MypicTask(holder.blackimgae);
        mypictask.execute(bean.getAvatar());
        return convertView;
    }
    //这个ViewHolder只能服务于当前这个特定的adapter，
    private class ViewHolder {
        ImageView love_image;
        TextView username;
        TextView citytext;
        TextView agetext;
        TextView mstext;
        ImageView blackimgae;

    }
    // 图片适配
    class MypicTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView imageView;

        public MypicTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
                urlconnection.setRequestMethod("GET");
                urlconnection.setReadTimeout(5000);
                urlconnection.setConnectTimeout(5000);
                //判断结果码
                if (urlconnection.getResponseCode() == 200) {
                    //得到资源
                    InputStream inputstream = urlconnection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
                    return bitmap;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap == null) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
    public interface Callback {
         public void callclick(View v);
     }
    /**
     * love按钮的监听接口
     */
    public interface onItemLoveListener {
         void onloveClick(int postion);
    }
    private onItemLoveListener monItemLoveListener1;
    public void setOnItemloveClickListener(onItemLoveListener monItemLoveListener) {
        this.monItemLoveListener1 = monItemLoveListener;
    }



}