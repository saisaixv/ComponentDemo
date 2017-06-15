package com.shunyi.cydex.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.shunyi.cydex.common.base.BaseRvAdapter;
import com.shunyi.cydex.common.base.BaseRvViewHolder;
import com.shunyi.cydex.news.R;
import com.shunyi.cydex.news.data.News;

import java.util.List;

/**
 * Created by saisai on 2017/6/14.
 */

public class NewsAdapter extends BaseRvAdapter<News.StoriesBean> {


    public NewsAdapter(Context context, List<News.StoriesBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_rv_news;
    }

    @Override
    protected BaseRvViewHolder onCreateViewHolder(int layoutId, int viewType) {
        return new NewViewHolder(LayoutInflater.from(context).inflate(layoutId,null));
    }

    @Override
    public void onBindViewHolder(BaseRvViewHolder holder, int position) {

        NewViewHolder viewHolder= (NewViewHolder) holder;

        News.StoriesBean bean = datas.get(position);

        Glide.with(context)
                .load(bean.getImages().get(0))
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(viewHolder.img);
        viewHolder.tvTitle.setText(bean.getTitle());
    }
}
