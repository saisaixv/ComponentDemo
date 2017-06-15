package com.shunyi.cydex.news.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunyi.cydex.common.base.BaseRvViewHolder;
import com.shunyi.cydex.news.R;

/**
 * Created by saisai on 2017/6/15.
 */

public class NewViewHolder extends BaseRvViewHolder {


    public ImageView img;
    public TextView tvTitle;

    public NewViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }
}
