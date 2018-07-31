package com.emarkova.session18.recycler.factories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater);
}
