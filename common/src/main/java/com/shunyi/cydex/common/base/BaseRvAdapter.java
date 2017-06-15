package com.shunyi.cydex.common.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by saisai on 2017/6/15.
 */

public abstract
class BaseRvAdapter<T> extends RecyclerView.Adapter<BaseRvViewHolder>{

    public Context context;
    public List<T> datas;
    public BaseRvAdapter(Context context,List<T> datas){
        this.context=context;
        this.datas=datas;
    }

    @Override
    public BaseRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolder(getLayoutId(),viewType);
    }

    protected abstract int getLayoutId();

    protected abstract BaseRvViewHolder onCreateViewHolder(int layoutId,int viewType);

    @Override
    public int getItemCount() {
        return datas.size();
    }

}
