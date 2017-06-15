package com.shunyi.cydex.girls.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.shunyi.cydex.common.base.BaseRvAdapter;
import com.shunyi.cydex.common.base.BaseRvViewHolder;
import com.shunyi.cydex.girls.R;
import com.shunyi.cydex.girls.data.Girls;

import java.util.List;

/**
 * Created by saisai on 2017/6/14.
 */

public class GirlsAdapter extends BaseRvAdapter<Girls.ResultsBean> {


    public GirlsAdapter(Context context, List<Girls.ResultsBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_rv_girls;
    }

    @Override
    protected BaseRvViewHolder onCreateViewHolder(int layoutId, int viewType) {
        return new GirlsViewHolder(LayoutInflater.from(context).inflate(layoutId,null));
    }

    @Override
    public void onBindViewHolder(BaseRvViewHolder holder, int position) {

        GirlsViewHolder viewHolder= (GirlsViewHolder) holder;
        Girls.ResultsBean resultsBean = datas.get(position);
        Glide.with(context)
                .load(resultsBean.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(viewHolder.img);
    }
}
