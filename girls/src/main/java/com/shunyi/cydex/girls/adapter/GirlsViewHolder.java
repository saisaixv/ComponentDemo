package com.shunyi.cydex.girls.adapter;

import android.view.View;
import android.widget.ImageView;

import com.shunyi.cydex.common.base.BaseRvViewHolder;
import com.shunyi.cydex.girls.R;

/**
 * Created by saisai on 2017/6/15.
 */

public class GirlsViewHolder extends BaseRvViewHolder {

    public ImageView img;

    public GirlsViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
    }
}
