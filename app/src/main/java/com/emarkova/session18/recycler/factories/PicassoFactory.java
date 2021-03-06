package com.emarkova.session18.recycler.factories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emarkova.session18.R;
import com.emarkova.session18.recycler.viewholders.PicassoViewHolder;

public class PicassoFactory implements ViewHolderFactory {
    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.item_layout,parent, false);
        return new PicassoViewHolder(view);
    }
}
