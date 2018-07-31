package com.emarkova.session18.recycler.binders;

import android.support.v7.widget.RecyclerView;

public interface ImageHolderBinder {

    public void bindViewHolder( RecyclerView.ViewHolder holder);
    public int getType();
}
