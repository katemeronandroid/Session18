package com.emarkova.session18.recycler.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.emarkova.session18.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView frescoDraweeView;

    public FrescoViewHolder(@NonNull View itemView) {
        super(itemView);
        frescoDraweeView = itemView.findViewById(R.id.fresco_image_view);
    }
}
